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

/**
 * this class is created for test use. it will test four aspects of CustomProcess class and check
 * whether they could pass or not
 * 
 * @author YIDA WU
 */
public class ProcessSchedulerTests {
  /**
   * this method is to test the functionality of enqueue method.
   * 
   * @return true if enqueue functions well
   */
  public static boolean testEnqueueCustomProcessQueue() {
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process = new CustomProcess(5);
    queue.enqueue(process);
    if (queue.peek().getBurstTime() == 5) {
      return true;
    } else {
      return false;
    }
  } // checks the correctness of the enqueue
  // operation implemented in the CustomProcessQueue class

  /**
   * this method is to test the functionality of dequeue method
   * 
   * @return true if dequeue functions well
   */
  public static boolean testDequeueCustomProcessQueue() {
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process = new CustomProcess(5);
    queue.enqueue(process);
    queue.dequeue();
    if (queue.isEmpty()) {
      return true;
    } else {
      return false;
    }
  } // checks the correctness of the dequeue
    // operation implemented in the CustomProcessQueue class

  /**
   * this method is to test the functionality of size method
   * 
   * @return true if get the right size
   */
  public static boolean testSizeCustomProcessQueue() {
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process = new CustomProcess(5);
    queue.enqueue(process);
    queue.dequeue();
    if (queue.size() == 0) {
      return true;
    } else {
      return false;
    }
  }// checks the correctness of the size
   // operation implemented in the CustomProcessQueue class

  /**
   * this method is to test he functionality of the isEmpty method
   * 
   * @return true if the queue is empty after all commands
   */
  public static boolean testIsEmptyCustomProcessQueue() {
    CustomProcessQueue queue = new CustomProcessQueue();
    CustomProcess process = new CustomProcess(5);
    queue.enqueue(process);
    queue.dequeue();
    if (queue.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }// checks the correctness of the isEmpty
   // operation implemented in the CustomProcessQueue class

  /**
   * the main method will executed all tests methods.
   * 
   * @param t indicator of the whether all test have been passed
   */
  public static void main(String[] args) {
    int t = 1;
    if (!testEnqueueCustomProcessQueue()) {
      System.out.println("testEnqueueCustomProcessQueue fails");// test 1 fails
      t = -1;
    }
    if (!testDequeueCustomProcessQueue()) {
      System.out.println("testDequeueCustomProcessQueue fails");// test 2 fails
      t = -1;
    }
    if (!testSizeCustomProcessQueue()) {
      System.out.println("testSizeCustomProcessQueue fails");// test 3 fails
      t = -1;
    }
    if (!testIsEmptyCustomProcessQueue()) {
      System.out.println("testIsEmptyCustomProcessQueue fails");// test 4 fails
      t = -1;
    }
    if (t == 1) { // only all test pass, t could be 1
      System.out.println("all tests have passed");
    }
  }
}
