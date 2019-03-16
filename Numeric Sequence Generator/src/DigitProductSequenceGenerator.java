//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DigitProductSequenceGenerator
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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * this is digit product sequence generator. This class implements the ArrayList.
 * 
 * @author Yida
 */
public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * this method is constructor of digit product sequence generator. it will exceptions when meets
   * something in valid.
   * 
   * @param init the input initial number
   * @param size the input size
   */
  public DigitProductSequenceGenerator(int init, int size) {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    // check for the validity of init (>=0) and diff (>0), throw an IllegalArgumentException
    // if these two parameters are not valid
    if (init < 1)
      throw new IllegalArgumentException(
          "WARNING: The starting element for digit product sequence cannot be less than or equal "
              + "to zero.");

    this.INIT = init;
    this.SIZE = size;
    sequence = new ArrayList<Integer>();
    generateSequence();
  }

  /**
   * this method is the core part of the digit product sequence generator. it will calculate the
   * correct digit product and add it to the sequence
   */
  public void generateSequence() {
    // TODO Generate the DigitProduct sequence using loop(s)
    sequence = new ArrayList<Integer>();
    sequence.add(INIT);
    for (int i = 0; i < this.SIZE-1; i++) {
      String number = String.valueOf(sequence.get(i));
      int product = 1;
      int j = 0;
      while (j < number.length()) {
        int temp = Integer.parseInt(number.substring(j, j + 1));
        if (temp > 0)
          product = product * temp;

        j++;
      }
      int num = sequence.get(i) + product;
      sequence.add(num);
    }
  }

  /**
   * this method is used to return iterator
   * 
   * @return the iterator of the class.
   */
  public Iterator<Integer> getIterator() {
    // TODO return an Iterator to iterate over the ArrayList sequence field
    Iterator<Integer> iterator = sequence.iterator();
    return iterator;
  }
}


