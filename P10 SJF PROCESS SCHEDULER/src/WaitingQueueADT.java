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
 * this is a interface which will be implemented in following program files.
 * 
 * @author YIDA WU
 * @param <T> generic type
 */
public interface WaitingQueueADT<T extends Comparable<T>> {

  /**
   * this method will enqueue an object
   * 
   * @param newObject the object to be enqueued
   */
  public void enqueue(T newObject); // inserts a newObject in the priority queue

  /**
   * this method will delete one object and print this deleted object
   * 
   * @return the first object in the queue
   */
  public T dequeue(); // removes and returns the item with the highest priority

  /**
   * this method will print the first object
   * 
   * @return the first object in the queue
   */
  public T peek(); // returns without removing the item with the highest priority

  /**
   * this method will get the size of the queue
   * 
   * @return the size of the queue
   */
  public int size(); // returns size of the waiting queue

  /**
   * this method checks whether the queue is empty or not
   * 
   * @return true if the queue is empty
   */
  public boolean isEmpty(); // checks if the waiting queue is empty
}
