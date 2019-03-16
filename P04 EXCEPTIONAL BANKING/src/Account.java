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
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This is a class that may throw varied exceptions
 * 
 * @author Yida
 * @param MAX_GROUPS             limits of transactions
 * @param nextUniqueId           a unique ID for use
 * @param name                   the name of the class
 * @param UNIQUE_ID              every trasaction's ID
 * @param transactionGroups      the set of transactions
 * @param transactionGroupsCount the number of transactions count
 *
 */
public class Account {

  private static final int MAX_GROUPS = 10000; // the upper limit of the store memory
  private static int nextUniqueId = 1000; // the unique ID used for every group

  private String name; // the name of string
  private final int UNIQUE_ID; // the ID varied
  private TransactionGroup[] transactionGroups; // create a new transaction group
  private int transactionGroupsCount; // the number counted

  /**
   * normal constructor of class
   * 
   * @param name the name in
   */
  public Account(String name) { // normal to start an account, only name is needed
    this.name = name;
    this.UNIQUE_ID = Account.nextUniqueId;
    Account.nextUniqueId++;
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    this.transactionGroupsCount = 0;
  }

  /**
   * constructor for reading file.
   * 
   * @param file     the file aimed to loaded
   * @param in       a scanner
   * @param nextLine a blank massage
   * @throws FileNotFoundException
   */
  public Account(File file) throws FileNotFoundException { // this is a way to load file to create
                                                           // an account for users
    // NOTE: THIS METHOD SHOULD NOT BE CALLED MORE THAN ONCE, BECAUSE THE
    // RESULTING BEHAVIOR IS NOT DEFINED WITHIN THE JAVA SPECIFICATION ...
    Scanner in = new Scanner(file);
    // ... THIS WILL BE UPDATED TO READ FROM A FILE INSTEAD OF SYSTEM.IN.

    this.name = in.nextLine();
    this.UNIQUE_ID = Integer.parseInt(in.nextLine());
    Account.nextUniqueId = this.UNIQUE_ID + 1;
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    this.transactionGroupsCount = 0; // processes to strat the account
    String nextLine = ""; // a useless line
    while (in.hasNextLine())
      try {
        this.addTransactionGroup(in.nextLine());
      } catch (DataFormatException e) {
        System.out.println("Caught DataFormatException: " + e.getMessage());
        // e.printStackTrace(); //helpful to check the faults
      }
    in.close();
  }

  /**
   * a method to get ID
   * 
   * @return UNIQUE_ID needed
   */
  public int getId() {
    return this.UNIQUE_ID;
  }

  /**
   * a method to add transaction group
   * 
   * @param command         input command
   * @param parts           a string set
   * @param newTransactions the converted command
   * @see TransactionGroup#TransactionGroup(int[])
   * @throws DataFormatException
   * @throws OutOfMemoryError
   */
  public void addTransactionGroup(String command) throws DataFormatException, OutOfMemoryError {
    String[] parts = command.split(" ");
    if (parts.length == 1)
      throw new DataFormatException("addTransactionGroup requires string commands that "
          + "contain only space separated integer values");// divided into two for code reader

    int[] newTransactions = new int[parts.length];
    for (int i = 0; i < parts.length; i++)
      try {
        newTransactions[i] = Integer.parseInt(parts[i]);
      } catch (NumberFormatException e) {
        throw new DataFormatException("addTransactionGroup requires string commands that contain "
            + "only space separated integer values"); // divided into two for code reader
      }
    TransactionGroup t = new TransactionGroup(newTransactions); // for storage
    if (this.transactionGroupsCount > MAX_GROUPS)
      throw new OutOfMemoryError("the capacity of array is " + MAX_GROUPS);
    this.transactionGroups[this.transactionGroupsCount] = t;
    this.transactionGroupsCount++;// end of method, this method is similar with the first assignment
  }

  /**
   * get the number of transaction count
   * 
   * @param transactionCount the number counted
   * @return the number counted
   */
  public int getTransactionCount() {
    int transactionCount = 0;
    for (int i = 0; i < this.transactionGroupsCount; i++)
      transactionCount += this.transactionGroups[i].getTransactionCount();
    return transactionCount;
  }

  /**
   * get the amount of transaction
   * 
   * @param index            the goal index
   * @param transactionCount the number
   * @see TransactionGroup#getTransactionCount()
   * @see TransactionGroup#getTransactionAmount()
   * @return one transaction amount
   * @throws IndexOutOfBoundsException
   */
  public int getTransactionAmount(int index) throws IndexOutOfBoundsException {
    int transactionCount = 0;
    if (index < 0)
      throw new IndexOutOfBoundsException("index must greater than 0, the input is " + index);
    // use a loop to better calculate the amount
    for (int i = 0; i < this.transactionGroupsCount; i++) {
      int prevTransactionCount = transactionCount;
      transactionCount += this.transactionGroups[i].getTransactionCount();
      if (transactionCount > index) {
        index -= prevTransactionCount; // find the correct index
        return this.transactionGroups[i].getTransactionAmount(index);
      }
    }
    // if function well, this method will be ended in advance
    // throws a error while index of bounds, it happens rarely
    throw new IndexOutOfBoundsException(
        "the total number of transactions is " + transactionCount + ", your index is " + index);
    // return -1;
  }

  /**
   * a method to get current balance
   * 
   * @param balance the balance
   * @param size    the transactions counted
   * @return current balance
   */
  public int getCurrentBalance() {
    // a easier method
    int balance = 0; 
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++)
      balance += this.getTransactionAmount(i);
    // above is a for loop without baskets.
    return balance;
  }

  /**
   * a method to get the number of overdraft
   * 
   * @param balance        the money
   * @param overdraftCount the times of overdraft
   * @size the length of transactions
   * @return overdraft time
   */
  public int getNumberOfOverdrafts() {
    int balance = 0;
    int overdraftCount = 0;
    int size = this.getTransactionCount();
    // to start the calculation of overdraft
    // this would will throw exception since all have been checked before
    for (int i = 0; i < size; i++) {
      int amount = this.getTransactionAmount(i);
      balance += amount;
      if (balance < 0 && amount < 0)
        overdraftCount++;
    }
    return overdraftCount;
  }
}
