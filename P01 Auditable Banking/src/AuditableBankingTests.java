//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AuditableBankingTests
// Files: AuditableBanking.java,AuditableBankingTests.java
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

import java.util.Arrays;

/**
 * The class AuditableBankingTests contains three methods (except main method) for users to use. The
 * function of this class is to test whether AuditableBanking can work well or not.
 * <p>
 * testProcessCommand: tests peocessCommand in AuditableBaking correctness.
 * <p>
 * testCalculateCurrentBalance: tests whether calculateCurrentBalance in AuditableBanking can work
 * well or not.
 * <p>
 * testCalculateNumberOfOverdrafts: tests the calculateNumberOfOverdrafts in AuditableBanking and
 * check the result.
 */

public class AuditableBankingTests {

  /**
   * Starts the whole test program.
   * 
   * @param result is an array to store the results of three tests methods.
   */
  public static void main(String[] args) {
    boolean[] result = new boolean[3];
    result[0] = testProcessCommand();
    result[1] = testCalculateCurrentBalance();
    result[2] = testCalculateNumberOfOverdrafts();
  }

  /**
   * to test the function of processCommand in AuditableBanking
   * 
   * @param allTransactions a test arrays to stored data.
   * @param countMember     is the number of transaction groups within allTransactions (before
   *                        newTransactions is added.
   * @param returnMember    is the number of transaction groups within allTransactions (after
   *                        newTransactions is added.
   * @param firstNumber     stores correct number of zero-index test arrays.
   * @param result          results of two tests.
   * @param testString      input string to test.
   * @return the results of two tests.
   * @see AuditableBanking.processCommand.
   */
  public static boolean testProcessCommand() {
    int[][] allTransactions = new int[100][];
    for (int i = 0; i < 2; i++) {
      allTransactions[i] = new int[] {1, 1, 1, 1, 1, 1};
    }
    int countMember = 2;
    int returnMember;
    int[] firstNumber = new int[] {0, 4};
    boolean[] result = new boolean[2];
    String[] testString = new String[] {"0 1 0 0 1 1 1 0 1", "4 0 0 1 1 0 1 1"};
    for (int i = 0; i < testString.length; i++) {
      returnMember = AuditableBanking.processCommand(testString[i], allTransactions, countMember);
      if (returnMember == countMember & returnMember == 100) {
        System.out.println("allTransactions is full");
        result[i] = false;
      } else if (returnMember == countMember) {
        System.out.println("invalid transaction");
        result[i] = false;
      } else if (allTransactions[2 + i][0] != firstNumber[i]) {
        System.out.println("error");
        result[i] = false;
      } else {
        System.out.println("tansaction is done");
        result[i] = true;
      }
    }
    return result[0] && result[1];
  }

  /**
   * to test the function of calculateCurrentBalance in AuditableBanking
   * 
   * @param allTransactions      a test arrays to stored data.
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @param result               balance sum.
   * @return Whether the balance calculated is right or not.
   * @see AuditableBanking.calculateCurrentBalance.
   */
  public static boolean testCalculateCurrentBalance() {
    int[][] allTransactions = new int[][] {{1, 1, 1, 1, 1}, {2, 2, 1, 0, 0}};
    int allTransactionsCount = 2;
    int result = AuditableBanking.calculateCurrentBalance(allTransactions, allTransactionsCount);
    if (result != -76) {
      System.out.println("Calculate error");
      return true;
    } else {
      System.out.println("Current Balance: " + result);
      return false;
    }
  }

  /**
   * to test the function of calculateNumberOfOverdrafts in AuditableBanking
   * 
   * @param foundProblem     to report problems.
   * @param transactions     a test arrays to stored data.
   * @param transactionCount is the number of transaction groups within allTransactions (before
   *                         newTransactions is added.
   * @param overdraft        times of overdrafts calculated in allTransactions array.
   * @return Whether a problem has detected or not.
   * @see AuditableBanking.calculateNumberOfOverdrafts.
   */
  public static boolean testCalculateNumberOfOverdrafts() {
    boolean foundProblem = false;
    int[][] transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                     // balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
        {1, 115}, // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
    };

    // test with a single transaction of the Integer Amount encoding
    int transactionCount = 1;
    int overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (overdrafts != 2) {
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

    // test with four transactions: including one of each encoding
    transactionCount = 4;
    overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);

    if (overdrafts != 5) {
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

    return !foundProblem;
  }

}
