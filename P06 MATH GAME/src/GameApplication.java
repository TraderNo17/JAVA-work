//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: GameApplication
// Files: GameOperator.java,GameList.java,GameNode.java,GameTests.java,GameApplication.java
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
import java.util.Random;
import java.util.Scanner;

/**
 * this class starts the math game is the core and frive of the whole game.
 * @author Yida Wu
 */
public class GameApplication {
  Random ran = new Random(); // random number generator
  public int goal; //the goal number
  public GameList list; // the list to store node
  public int count;// the number counted

  /**
   * this constructor initializes the game goal and add 7 random number into game list.
   */
  public GameApplication() {
    count = 0; // initialize to 0
    this.goal = ran.nextInt(90) + 10;
    list = new GameList();
    for (int i = 0; i < 7; i++) { // add 7 random numbers
      list.addNode(new GameNode(ran));
    }
  }

  /**
   * the main method starts the whole program.
   * @param args
   * @param game the game object
   */
  public static void main(String[] args) {
    GameApplication game = new GameApplication(); // create the interface
    game.Application(game); // pass throw game object
  }

  /**
   * this method override the toString method and and print the nessary information for users.
   * @param s the string to store information
   * @see java.lang.Object#toString()
   * @return s the string
   */
  @Override
  public String toString() {
    String s = "Goal: " + goal + " Moves Taken: " + count + "\r\n" + "Puzzle: ";
    s = s + list.toString() + "\r\n" + "Number and Operation " + GameOperator.ALL_OPERATORS
        + "to Apply: ";// the information needed in the interface
    return s;
  }

  /**
   * the core part of the program, start and operate the math game
   * @param game the game object
   * @param sc the scanner for input
   */
  public void Application(GameApplication game) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Math Game!"); // beginning words
    System.out.print(game);
    while (GetInput(sc)) { // ckeck whether the game needed to be ceased
      System.out.println();
      if (list.contains(goal)) {
        System.out
            .println("Congratulations : you won in " + count + "moves" + "\r\nSolutions" + list);
        sc.close(); // close the scanner to close the program
        break;
      }
      System.out.print(game);// the turn result
    }
  }

  /**
   * get the input and calculate the input. and exceptions dealer
   * @param sc the scanner
   * @param s the string to temporarily store the string.
   * @return true while the user do not intended to exit the game
   */
  public boolean GetInput(Scanner sc) {
    String s; //to store the input number 
    s = sc.nextLine().trim();
    if (s.toLowerCase().equals("quit")) { // transform to lower case for checking
      System.out.println("Goodbye");
      return false; // false to exit the game
    }
    try { // exceptions will indicates input correctness
      GameOperator operator = GameOperator.getFromChar(s.charAt(s.length() - 1));
      int number = Integer.parseInt(s.substring(0, s.length() - 1));
      if (!list.contains(number)) {  // wrong number input
        System.err.println("WARNING: Please enter valid number");
        return true;
      }
      list.addNode(new GameNode(ran));
      list.applyOperatorToNumber(number, operator);
      count++;
    } catch (IndexOutOfBoundsException e) {
      System.err.println("WARNING: Please re-enter"); //unknown input
    } catch (NumberFormatException e) {
      System.err.println("WARNING: Please enter correct operator!"); // wrong operator input
    } catch (NullPointerException e) {
      System.err.println("WARNING: Please enter correct command!"); // wrong format of input
    }
    return true;
  }
}
