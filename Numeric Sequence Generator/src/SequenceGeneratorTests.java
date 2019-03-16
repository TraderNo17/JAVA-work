//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SequenceGeneratorTests
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
 * this class is to test different sequenceGenertors
 * 
 * @author Yida
 */
public class SequenceGeneratorTests {
  /**
   * Test the geometricSequenceGenerator class. check whether there are flaws.
   * 
   * @param test1 the geometric sequence generator
   * @param count the counted number.
   * @return true if pass the test and false otherwise
   */
  public static boolean geometricSequenceGeneratorTest() {
    GeometricSequenceGenerator test1 = new GeometricSequenceGenerator(4, 2, 5);// create a new
    // reference type with initial number 4 and ratio 2 and size 5
    int count = 0;// count is setted to 0
    while (test1.hasNext()) {// check whether it has next input
      test1.next();// set the next input
      count++;// increment count
    }
    if (count == 5) {// if the size is 5 return true and false otherwise
      return true;
    }
    return false;
  }

  /**
   * this method is to test three methods in fibonacciSequenceGenerator
   * 
   * @param test2 the test object
   * @param the   number counted
   * @return true if it count is 5 and false otherwise
   */
  public static boolean fibonacciSequenceGeneratorTest() {
    FibonacciSequenceGenerator tset2 = new FibonacciSequenceGenerator(5);
    // create a new reference type with initial size 5
    int count = 0;// count is begin as 0
    while (tset2.hasNext()) {// check whether it has next input
      tset2.next();// set the next input
      count++;// increment of count
    }
    if (count == 5) {// if the size is 5 return true and false otherwise
      return true;
    }
    return false;
  }

  /**
   * test the digitProductSequenceGenerator method
   * 
   * @param dig      the test object
   * @param count    the number counted
   * @param iterator the iterator used in test
   * @return true if it pass the test and false otherwise
   */
  public static boolean digitProductSequenceGeneratorTest() {
    DigitProductSequenceGenerator dig = new DigitProductSequenceGenerator(5, 5);
    // create a new reference type of digit productsequencegenerator with initial number 5 and size
    // 5
    int count = 0;// count is 0
    Iterator<Integer> iterator = dig.getIterator();// do the iterator
    while (iterator.hasNext()) {// check whether it has next input
      iterator.next();// set the next iterator
      count++;// increment of count
      if (count == 5) {// check whether the count is 5
        // true if it is 5 and false otherwise
        return true;
      }
    }
    return false;
  }

  /**
   * main method that runs the class. this method would start check procedure of the program
   * 
   * @param fails the number of failures
   * @param args  command
   */
  public static void main(String[] args) {
    int fails = 0;// set a number named fails to check
    if (!geometricSequenceGeneratorTest()) {// do the test 1 and
      // if it is returns fasle, than print
      System.out.println("Fail to pass geometricSequenceGenerator test");
      fails++;// fails increment
    }
    if (!fibonacciSequenceGeneratorTest()) {
      // do the test of fibonaccisequence if fails print out
      System.out.println("Fail to pass fibonacciSequenceGerator test");
      fails++;// fails increment
    }
    if (!digitProductSequenceGeneratorTest()) {
      // do the digit ptoduct sequence and print out if fails
      System.out.println("Fail to pass digitProductSequenceGerator test");
      fails++;// fails increment
    }
    if (fails == 0) {// if no fails find print all tests are passed
      System.out.println("All tests are passed");
    }
  }
}

