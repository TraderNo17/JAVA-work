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

import java.util.zip.DataFormatException;

/**
 * this class is a transaction group
 * 
 * @param EncodingType the input type
 * @param values       the current content of transaction group
 * @author Yida
 * 
 */
public class TransactionGroup {

  private enum EncodingType {
    BINARY_AMOUNT, INTEGER_AMOUNT, QUICK_WITHDRAW
  };

  private EncodingType type; // global variables
  private int[] values;

  /**
   * a constructor to build the tansaction.
   * 
   * @param groupEncoding
   * @throws DataFormatException
   */
  public TransactionGroup(int[] groupEncoding) throws DataFormatException {
    if (groupEncoding.equals(null) || groupEncoding.length == 0)
      throw new DataFormatException("transaction group encoding cannot be null or empty");
    if (groupEncoding[0] < 0 || groupEncoding[0] > 2)
      throw new DataFormatException(
          "the first element within a transaction group must be 0, 1, or 2");
    if (groupEncoding[0] == 0) {
      for (int i = 1; i < groupEncoding.length; i++) {
        if (groupEncoding[i] != 0 && groupEncoding[i] != 1)
          throw new DataFormatException(
              "binary amount transaction groups may only contain 0s and 1s");
      }
    }
    if (groupEncoding[0] == 1) {
      for (int i = 1; i < groupEncoding.length; i++) {
        if (groupEncoding[i] == 0)
          throw new DataFormatException("integer amount transaction groups may not contain 0s");
      }
    }
    if (groupEncoding[0] == 2 && groupEncoding.length != 5) {
      throw new DataFormatException("quick withdraw transaction groups must contain 5 elements");
    }
    if (groupEncoding[0] == 2) {
      for (int i = 1; i < groupEncoding.length; i++) {
        if (groupEncoding[i] < 0)
          throw new DataFormatException(
              "quick withdraw transaction groups may not contain negative numbers");
      }
    }
    // above are used to tested whether input is valid

    this.type = EncodingType.values()[groupEncoding[0]]; // if input is valid, these code will be
                                                         // excuted
    this.values = new int[groupEncoding.length - 1];
    for (int i = 0; i < values.length; i++)
      this.values[i] = groupEncoding[i + 1];
  }

  /**
   * a method to get transactions counted
   * 
   * @param transactionCount number
   * @return counted number
   */
  public int getTransactionCount() {
    int transactionCount = 0;
    switch (this.type) {
      case BINARY_AMOUNT: // the special approach used by binary account
        int lastAmount = -1;
        for (int i = 0; i < this.values.length; i++) {
          if (this.values[i] != lastAmount) {
            transactionCount++;
            lastAmount = this.values[i];
          }
        }
        break;
      case INTEGER_AMOUNT: // the special approach used by integer account
        transactionCount = values.length;
        break;
      case QUICK_WITHDRAW: // the special approach used by quick withdraw account
        for (int i = 0; i < this.values.length; i++)
          transactionCount += this.values[i];
    }
    return transactionCount;
  }

  /**
   * a method to get transaction Amount
   * 
   * @param transactionIndex
   * @param transactionCount counted number
   * @returnc the amount counted, if there is 0 amount, it will return -1
   * @throws IndexOutOfBoundsException
   */
  public int getTransactionAmount(int transactionIndex) throws IndexOutOfBoundsException {
    if (transactionIndex < 0 || transactionIndex > (getTransactionCount() - 1))
      throw new IndexOutOfBoundsException("the total number of transactions is "
          + (getTransactionCount()) + " ,and your index is " + transactionIndex);
    // used to determine whether input type is correct or not

    int transactionCount = 0;
    switch (this.type) { // find the correct way to calculate
      case BINARY_AMOUNT:
        int lastAmount = -1;
        int amountCount = 0;
        for (int i = 0; i <= this.values.length; i++) {
          if (i == this.values.length || this.values[i] != lastAmount) { // determination of
                                                                         // validation of binary
                                                                         // account
            if (transactionCount - 1 == transactionIndex) {
              if (lastAmount == 0)
                return -1 * amountCount;
              else
                return +1 * amountCount;
            }
            transactionCount++;
            lastAmount = this.values[i];
            amountCount = 1;
          } else
            amountCount++;
          lastAmount = this.values[i];
        }
        break;
      case INTEGER_AMOUNT:
        return this.values[transactionIndex];
      case QUICK_WITHDRAW:
        final int[] QW_AMOUNTS = new int[] {-20, -40, -80, -100}; // multipler for calculation
        for (int i = 0; i < this.values.length; i++)
          for (int j = 0; j < this.values[i]; j++)
            if (transactionCount == transactionIndex)
              return QW_AMOUNTS[i];
            else
              transactionCount++;
    }
    return -1; // only if all above ways are not used
  }
}
