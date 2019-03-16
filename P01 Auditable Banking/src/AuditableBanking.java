//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AuditableBanking
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

import java.util.Scanner;

/**
 * The class AuditableBanking contains five methods (except main method) for users to use. The
 * function of this class is a AuditableBanking sytem and use can deposit and withdraw money.
 * <p>
 * submitTransactions: adds a new transaction into the account.
 * <p>
 * processCommand: process the user's input to classify the commands and call different type of
 * methods to process these inputs.
 * <p>
 * calculateCurrentBalance: calculate the balance all transactions.
 * <p>
 * calculateNumberOfOverdrafts: calculate the number of overdrafts in all transactions.
 * <p>
 * driveApplication: runs the interface
 */
public class AuditableBanking {

  /**
   * Starts the whole program.
   */
  public static void main(String[] args) {
    driveApplication();
  }

  /**
   * Adds a transaction group to an array of transaction groups. If the allTransactions array is
   * already full then this method will do nothing other than return allTransactionCount.
   * 
   * @param newTransactions      is the new transaction group being added (perfect size).
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */
  public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
      int allTransactionsCount) {

    if (allTransactions.length == allTransactionsCount) {
      return allTransactionsCount;
    }

    allTransactions[allTransactionsCount] = newTransactions;
    allTransactionsCount++;
    return allTransactionsCount;
  }

  /**
   * Processes a new command. According to different command, this method will implement different
   * methods in this class.
   * 
   * @param newTransactions      is the new transaction group being added (perfect size).
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @param checker              Temporarily store uppercase command.
   * @param newTransactions      Stores the result of processed command.
   * @param temp                 is the split command
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */
  public static int processCommand(String command, int[][] allTransactions,
      int allTransactionsCount) {
return -1;
  }
/*    command = command.trim();
    String checker = command.toUpperCase();
    if (checker.charAt(0) == 'B') {
      System.out.println(
          "Current Balance: " + calculateCurrentBalance(allTransactions, allTransactionsCount));
      allTransactionsCount++;
      return allTransactionsCount;
    } else if (checker.charAt(0) == 'O')

    {
      System.out.println("Number of Overdrafts:"
          + calculateNumberOfOverdrafts(allTransactions, allTransactionsCount));
      // allTransactionsCount++;
      return allTransactionsCount;
    } else if (checker.charAt(0) == 'Q') {
      return -1;
    }

    String[] temp = command.split("\\s+");
    int[] newTransactions = new int[temp.length];

    for (int i = 0; i < temp.length; i++) {
      newTransactions[i] = Integer.parseInt(temp[i]);
    }

    if (newTransactions[0] < 0 | newTransactions[0] > 2) {
      return allTransactionsCount;
    }

    allTransactionsCount =

        submitTransactions(newTransactions, allTransactions, allTransactionsCount);

    return allTransactionsCount;
  }*/

  /**
   * Calculates the balance of account. If an error is detected, it will repeats a message.
   * 
   * @param sum                  is total balance of all transactions.
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @return the total current balance within allTransactions after newTransactions is added.
   */
  public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
    int sum = 0;
    for (int i = 0; i < allTransactionsCount; i++) {

      switch (allTransactions[i][0]) {

        case 0:
          for (int j = 1; j < allTransactions[i].length; j++) {
            if (allTransactions[i][j] == 0) {
              sum -= 1;
            } else if (allTransactions[i][j] == 1) {
              sum += 1;
            }
          }
          break;
        case 1:
          for (int j = 1; j < allTransactions[i].length; j++) {
            sum = sum + allTransactions[i][j];
          }
          break;
        case 2:
          sum = sum - 20 * allTransactions[i][1] - 40 * allTransactions[i][2]
              - 80 * allTransactions[i][3] - 100 * allTransactions[i][4];
          break;
        default:
          System.out.println("Detect an invalid transaction");
      }
    }

    return sum;
  }

  /**
   * Calculates the total overdrafts of account. If there is an invalid transaction in account, this
   * method will report.
   * 
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @param sum                  is total balance of account.
   * @param timeOverdrafts       is numbers of overdrafts.
   * @return the number of overdrafts within allTransactions after newTransactions is added.
   */
  public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
    int sum = 0;
    int timeOverdraft = 0;
    for (int i = 0; i < allTransactionsCount; i++) {
      switch (allTransactions[i][0]) {
        case 0:
          for (int j = 1; j < allTransactions[i].length; j++) {
            if (allTransactions[i][j] == 0) {
              sum -= 1;
            } else if (allTransactions[i][j] == 1) {
              sum += 1;
            }
            if (sum < 0 && allTransactions[i][j] == 0) {
              timeOverdraft++;
            }
          }
          break;
        case 1:
          for (int j = 1; j < allTransactions[i].length; j++) {
            sum = sum + allTransactions[i][j];
            if (sum < 0 && allTransactions[i][j] < 0) {
              timeOverdraft++;
            }
          }
          break;
        case 2:
          for (int j = 1; j < 5; j++) {
            for (int k = 0; k < allTransactions[i][j]; k++) {
              sum = sum - 20 * j;
              if (j > 2) {
                sum = sum - 20;
              }
              if (sum < 0) {
                timeOverdraft++;
              }
            }
          }
          break;
        default:
          System.out.println("Detect an invalid transaction");
      }
    }
    return timeOverdraft;
  }

  /**
   * A drive application to launch the program.
   * 
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @param comand               is the texts input.
   * @param scan                 is the scanner for texts.
   * @return none.
   */
  public static void driveApplication() {
    int[][] allTransactions = new int[100][];
    int allTransactionsCount = 0;
    String command;
    Scanner scan = new Scanner(System.in);
    System.out.println("========== Welcome to the Auditable Banking App ==========");
    while (allTransactionsCount != -1) {
      System.out.println("COMMAND MENU:\r\n"
          + "  Submit a Transaction (enter sequence of integers separated by spaces)\r\n"
          + "  Show Current [B]alance\r\n" + "  Show Number of [O]verdrafts\r\n"
          + "  [Q]uit Program");
      System.out.print("ENTER COMMAND: ");
      command = scan.nextLine();
      allTransactionsCount = processCommand(command, allTransactions, allTransactionsCount);
      System.out.println();
    }
    System.out.println("============ Thank you for using this App!!!! ============");
  }
}
