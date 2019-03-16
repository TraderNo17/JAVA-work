

import java.util.*;
public class AuditableBankingTests {

  public static void main(String[] args) {
    boolean result;
    result = testProcessCommand();

  }

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

  public static boolean testCalculateCurrentBalance() {
    // TODO: Implement this method
    return false;
  }

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
