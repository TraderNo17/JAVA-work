//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: FibonacciSequenceGenerator
// Files: ArithmeticSequenceGenerator.java,DigitProductSequenceGenerator.java
// ,FibonacciSequenceGenerator.java,GeometricSequenceGenerator.java,
// Sequence.java,SequenceGeneratorTests.java,
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

import java.util.Iterator;

/**
 * this class is used to generator the correct Fibonacci sequence. This class implements the
 * Iterator<Integer> interface
 * 
 * @author Yida Wu
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far



  /**
   * this is the constructor of the class. it will initiate values in an object.
   * 
   * @param size the input size
   */
  // constructor
  public FibonacciSequenceGenerator(int size) {
    // Your code comes here
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    this.SIZE = size;
    this.prev = 0;
    this.next = 1;
    generatedCount = 0;
  }


  // Override hasNext() and next() methods
  /**
   * Checks if the iteration has a next element in this sequence
   * 
   * @return true if the current element in the iteration has a next element in this sequence, false
   *         otherwise
   */
  @Override
  public boolean hasNext() {
    // TODO Your code comes here
    // time complexity: O(1)
    return generatedCount < SIZE;
  }

  /**
   * Returns the next element in this Fibonacci sequence iteration with respect to the numbers
   * generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public Integer next() {
    // time complexity: O(1)
    // TODO Your code comes here
    if (generatedCount == 0) {
      generatedCount++;
      return 0;
    }
    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    int current = next; // set the current element to next
    generatedCount++; // increment the number of generated elements so far
    next += prev; // set the next element
    prev = current; // set the prev element
    return current; // return the current number as the generated one
  }

  // You CAN add public accessor and mutator methods as needed here in order to implement your test
  // methods

}
