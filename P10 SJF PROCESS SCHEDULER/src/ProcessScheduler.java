//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF PROCESS SCHEDULER
// Files: CustomProcess.java,CustomProcessQueue.java,ProcessScheduler.java,
// ProcessSchedulerTests.java,WaitingQueueADT.java
// Course: CS300,fall,2018
//
// Author: Yida Wu
// Email: ywu479@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

/**
 * this is core part of the program. driver is also in this class. this class will start the driver
 * and control all functions of this program.
 * 
 * @author YIDA WU
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  /**
   * this is the constructor of the class, it will initialize values.
   */
  public ProcessScheduler() {
    this.currentTime = 0;
    this.numProcessesRun = 0;
    queue = new CustomProcessQueue(); // create new queue to implement commands
  }

  /**
   * this method will make a command to be enqueued into the process array.
   * 
   * @param process the process command.
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process); // just enqueue objects
  }

  /**
   * this method will run the process command and print out useful information.
   * 
   * @param temp temporary to store the message.
   * @return the massage of the status to be printed out.
   */
  public String run() {
    String temp = "";
    if (queue.size() == 0) {// check whether the queue is empty or not.
      return "You cannot run a empty queue.";
    }
    while (queue.size() > 0) { // while loop will not stop until all the commands have been
                               // executed.
      numProcessesRun++;
      int id = queue.peek().getProcessId();
      int time = queue.dequeue().getBurstTime();
      temp += "Time " + currentTime + " : Process ID " + id + " Starting.\n";
      currentTime += time;
      temp += "Time " + currentTime + " : Process ID " + id + " Completed.\n";
    }
    temp += "\nTime " + currentTime + " : All scheduled processes completed.";
    return temp; // return the message to print
  }

  /**
   * this is the main method of the whole program. in this main method, it also contains driver of
   * the program which will create a interface. This class will check the validity of multiple
   * commands and check the running statuses.
   * 
   * @param ps the ProcessScheduler to better implement non-static methods in the class.
   * @param sc the scanner to scan the input.
   */
  public static void main(String[] args) {
    ProcessScheduler ps = new ProcessScheduler();
    // create an ProcessScheduler to better execute commands in this method.
    Scanner sc = new Scanner(System.in);
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========");
    while (true) { // loop will not stop util the quit command entered.
      System.out.println("\n" + "Enter command:\n" + "[schedule <burstTime>] or [s <burstTime>]\n"
          + "[run] or [r]\n" + "[quit] or [q]\n");
      String command = sc.nextLine();
      if (command.equals("quit") || command.equals("q")) {
        System.out.println(ps.numProcessesRun + " processes run in " + ps.currentTime
            + " units of time!\n" + "Thank you for using our scheduler!\n" + "Goodbye!");
        sc.close(); // close the scanner.
        return;
      }
      String[] cmd = command.split(" ");
      if (cmd[0].equals("schedule") || cmd[0].equals("s")) {
        int burstTime = 0;
        try { // check whether input is valid or not.
          burstTime = Integer.parseInt(cmd[1]);
        } catch (NumberFormatException e) {
          System.out.println("WARNING: burst time MUST be an integer!");
          continue;
        }
        if (burstTime <= 0) { // ensure the input is positive.
          System.out.println("WARNING: burst time MUST be greater than 0!");
          continue;
        }
        CustomProcess process = new CustomProcess(burstTime);
        // create the process command to be enqueue
        ps.scheduleProcess(process);
        System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
            + process.getBurstTime());
      } else if (cmd[0].equals("run") || cmd[0].equals("r")) {
        int num = ps.queue.size();
        if (num <= 1)
          System.out.println("Starting 1 process\n");
        if (num > 1)
          System.out.println("Starting " + num + " processes\n");
        System.out.println(ps.run());
      } else {
        System.out.println("WARNING: Please enter a valid command!");
        // is no cammand is executed, this warning will show up
      }
    }
  }
}
