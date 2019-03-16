//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Files: (a list of all source files used by that program)
// Course: (course number, term, and year)
//
// Author: (your name)
// Email: (your @wisc.edu email address)
// Lecturer's Name: (name of your lecturer)
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
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.*;

public class AuditableBanking {

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

  public static int processCommand(String command, int[][] allTransactions,
      int allTransactionsCount) {
    command = command.trim();
    String checker = command.toUpperCase();
    if (checker.charAt(0) == 'B') {
      System.out.println(
          "Current Balance: " + calculateCurrentBalance(allTransactions, allTransactionsCount));
      // allTransactionsCount++;
      return allTransactionsCount;
    } else if (checker.charAt(0) == 'O') {
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
  }

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
            if (sum < 0) {
              timeOverdraft++;
            }
          }
          break;
        case 1:
          for (int j = 1; j < allTransactions[i].length; j++) {
            sum = sum + allTransactions[i][j];
          }
          if (sum < 0) {
            timeOverdraft++;
          }
          break;
        case 2:
          for (int j = 1; j < 5; j++) {
            sum = sum - allTransactions[i][j] * 20 * j;
            if (j > 2) {
              sum = sum - 20 * allTransactions[i][j];
            }
            if (sum < 0) {
              timeOverdraft++;
            }
          }
          break;
        default:
          System.out.println("Detect an invalid transaction");
      }
    }
    return timeOverdraft;
  }

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
