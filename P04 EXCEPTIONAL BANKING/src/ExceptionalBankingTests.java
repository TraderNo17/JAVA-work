//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: EXCEPTIONAL BANKING
// Files: ExceptionalBanking.java,Account.java,TransactionGroup.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

/**
 * This is a class that tests other classes functionality.
 * 
 * @author Yida
 *
 */
public class ExceptionalBankingTests {

  /**
   * main method to start the program.
   * 
   * @param args
   */
  public static void main(String[] args) {
    if (testAccountBalance())
      System.out.println("testAccountBalance true"); // the first test method
    if (testOverdraftCount())
      System.out.println("testOverdraftCount true");// the second test method
    if (testTransactionGroupEmpty())
      System.out.println("testTransactionGroupEmpty true");// the third test method
    if (testTransactionGroupInvalidEncoding())
      System.out.println("testTransactionGroupInvalidEncoding true");// the fourth test method,
                                                                     // testing the exception report
    if (testAccountAddNegativeQuickWithdraw())
      System.out.println("testAccountAddNegativeQuickWithdraw true");// the fifth test method
    if (testAccountBadTransactionGroup())
      System.out.println("testAccountBadTransactionGroup true");// the sixth test method testing the
                                                                // exception report
    if (testAccountIndexOutOfBounds())
      System.out.println("testAccountIndexOutOfBounds true");// the seventh test method testing the
                                                             // functionality of account
    if (testAccountMissingFile())
      System.out.println("testAccountMissingFile true");// the third eighth method
  }

  /**
   * This method checks whether the testAccountBlance calculate the balance correctly.
   * 
   * @param ac    a new Account object
   * @param input the input string data
   * @see Account#addTransactionGroup(String)
   * @see Account#getCurrentBalance()
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountBalance() {
    Account ac = new Account("111");
    // set an input set in advance
    String[] input = new String[] {"0 0 0 1 1 0", "1 12 13 15 -50 -60", "2 1 2 3 1"};
    // for loop to complete the input set
    for (int i = 0; i < input.length; i++) {
      try {
        ac.addTransactionGroup(input[i]);
      } catch (OutOfMemoryError | DataFormatException e) {
        // e.printStackTrace();
        return false;
      }
    }
    // to check the answer
    if (ac.getCurrentBalance() == -511)
      return true;
    else
      return false;
  }

  /**
   * This method checks whether the testOverdraftCount calculate the overdraft correctly.
   * 
   * @param ac    a new Account object
   * @param input the input string data
   * @see Account#addTransactionGroup(String)
   * @see Account#getNumberOfOverdrafts()
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testOverdraftCount() {
    // create a account for testing
    Account ac = new Account("111");
    // set an input set in advance
    String[] input = new String[] {"0 0 0 1 1 0", "1 12 13 15 -50 -60", "2 1 2 3 1"};
    for (int i = 0; i < input.length; i++) {
      try {
        ac.addTransactionGroup(input[i]);
      } catch (OutOfMemoryError | DataFormatException e) {
        // e.printStackTrace();
        return false;
      }
    }
    // check whether the overdraft amount is correct or not
    if (ac.getNumberOfOverdrafts() == 11)
      return true;
    else
      return false;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when it is passed an empty int[].
   * 
   * @param group a new transaction group
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTransactionGroupEmpty() {
    // try for the exception report
    try {
      TransactionGroup group = new TransactionGroup(new int[0]);
    } catch (DataFormatException e) {
      if (e.getMessage().equals("transaction group encoding cannot be null or empty"))
        return true;
    }
    // if not catch, it will trigger the false return
    return false;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when then first int in the provided array is not 0, 1, or 2.
   * 
   * @param group a new transaction group
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTransactionGroupInvalidEncoding() {
    // this try create temporary int set inside the parameter.
    try {
      TransactionGroup group = new TransactionGroup(new int[] {3, 2, 4, 6});
    } catch (DataFormatException e) {
      if (e.getMessage().equals("the first element within a transaction group must be 0, 1, or 2"))
        return true;
    }
    // if not catch, it will trigger the false return
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a quick withdraw encoded group that contains negative
   * numbers of withdraws.
   * 
   * @param ac a new Account object
   * @see Account#addTransactionGroup(String)
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountAddNegativeQuickWithdraw() {
    // create some variables in try block
    try {
      Account ac = new Account("111");
      ac.addTransactionGroup("2 -1 2 4 6");
    } catch (DataFormatException e) {
      if (e.getMessage()
          .equals("quick withdraw transaction groups may not contain negative numbers"))
        return true;
    }
    // if not catch, it will trigger the false return
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a string with space separated English words (non-int).
   * 
   * @param ac a new Account object
   * @see Account#addTransactionGroup(String)
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountBadTransactionGroup() {
    // create some variables in try block
    try {
      Account ac = new Account("111");
      ac.addTransactionGroup("a b c d e");
    } catch (DataFormatException e) {
      if (e.getMessage()
          .equals("addTransactionGroup requires string commands that contain only space separated "
              + "integer values"))
        return true;
    }
    // if not catch, it will trigger the false return
    return false;
  }

  /**
   * This method checks whether the Account.getTransactionAmount method throws an exception with an
   * appropriate message, when it is passed an index that is out of bounds.
   * 
   * @param ac    a new Account object
   * @param index index of retrieved data
   * @see Account#addTransactionGroup(String)
   * @see Account#getTransactionAmount(int)
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountIndexOutOfBounds() {
    Account ac = new Account("111");
    int index = 8;
    // try for only one purposed exception check
    // but multiple catch will be thrown by command in try
    // last two catch are used to prevent grammar mistakes
    try {
      ac.addTransactionGroup("1 2 3 6 12 8");
      ac.getTransactionAmount(index);
    } catch (IndexOutOfBoundsException e) {
      if (e.getMessage().equals("the total number of transactions is " + ac.getTransactionCount()
          + ", your index is " + index))
        return true;
    } catch (OutOfMemoryError e) {
    } catch (DataFormatException e) {
    }
    // if not catch, it will trigger the false return
    return false;
  }

  /**
   * This method checks whether the Account constructor that takes a File parameter throws an
   * exception with an appropriate message, when it is passed a File object that does not correspond
   * to an actual file within the file system.
   * 
   * @param ac a new Account object
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountMissingFile() {
    // catch specified for FileNotFoundException
    try {
      Account ac = new Account(new File("123.txt"));
    } catch (FileNotFoundException e) {
      return true;
    }
    // if not catch, it will trigger the false return
    return false;
  }
}
