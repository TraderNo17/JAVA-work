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
 * this class implements comparable interface with CustomProcess type data. it will also be stored
 * as a object in array in nest file. This class has four methods centered around burst time.
 * 
 * @author YIDA WU
 */
public class CustomProcess implements Comparable<CustomProcess> {
  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * this is constructor of the class and initialize values.
   * 
   * @param burstTime the time taken to process
   */
  public CustomProcess(int burstTime) {
    this.PROCESS_ID = nextProcessId;
    this.burstTime = burstTime;
    nextProcessId++; // to keep every id is unique
  }

  /**
   * this is a getter method
   * 
   * @return the unique id
   */
  public int getProcessId() {
    return this.PROCESS_ID; // get the private field
  }

  /**
   * this is a getter method
   * 
   * @return the burst time.
   */
  public int getBurstTime() {
    return this.burstTime; // get the private field
  }

  /**
   * this method override compareTo method p1.compareTo(p2) < 0 means that the p1 has higher
   * priority than p2. So, p1 should be run first. p1.compareTo(p2) == 0 means that p1 and p2 have
   * exactly the same priority. p1.compareTo(p2) > 0 means that p1 has lower priority than p2.
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(CustomProcess p) {
    if (this.burstTime < p.getBurstTime()) {
      return -1;
    } else if (this.burstTime > p.getBurstTime()) {
      return 1;
    } else {
      if (this.PROCESS_ID < p.getProcessId()) { // situation that two process have same burst time.
        return -1;
      } else if (this.PROCESS_ID > p.getProcessId())
        return 1;
    }
    return 0; // almost impossible.
  }
}
