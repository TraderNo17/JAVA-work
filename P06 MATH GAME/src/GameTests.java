//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: GameTests
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

/**
 * this method is to test the functionality of the program
 * 
 * @author Yida Wu
 */
public class GameTests {
  static Random ran = new Random(); // random number generator

  /**
   * the main method to start the test
   * 
   * @param args
   * @param result the indicator of the result
   */
  public static void main(String[] args) {
    boolean result = true; // if the tests all passed, it will remain true
    if (!GameNodeTest1()) {
      System.out.println("Number is not in valid"); // test1 result
      result = false;
    }
    if (!GameNodeTest2()) {
      System.out.println("setNext fails"); // test 2 result
      result = false;
    }
    if (!GameListTest1()) {
      System.out.println("add a node fails"); // test 3 result
      result = false;
    }
    if (!GameListTest2()) {
      System.out.println("toString fails");// result 4 result
      result = false;
    }
    if (result == true) {
      System.out.println("all tests pass"); // only all tests pass happens
    }
  }

  /**
   * check a the auto generated number is correct or not
   * 
   * @param node the game node
   * @return true is the number falls in 1-9, false otherwise
   */
  public static boolean GameNodeTest1() { 
    GameNode node = new GameNode(ran);
    if (node.getNumber() < 1 || node.getNumber() > 9) { // check the range of the number in node
      return false;
    }
    return true;
  }


  /**
   * this method checks whether the number could be set correctly
   * 
   * @param node the game node
   * @return true when the next node is set correctly. false otherwise
   */
  public static boolean GameNodeTest2() {
    GameNode node = new GameNode(ran); 
    node.setNext(new GameNode(ran));
    if (node.getNext() == null) { // check the nest object
      return false;
    }
    return true;
  }


  /**
   * this methods checks whether node could be added correctly
   * 
   * @param list the game list
   * @param node the game node
   * @return true when the node is corrected added
   */
  public static boolean GameListTest1() {
    GameList list = new GameList();
    GameNode node = new GameNode(ran); // add known number into the list
    list.addNode(node);
    if (list.contains(node.getNumber())) { // here to check whether the coorect number being added
      return true;
    }
    return false;
  }


  /**
   * this method checks whether whether to string could generate a correct end
   * 
   * @param list the game list
   * @return true when the result of to string is right, false otherwise
   */
  public static boolean GameListTest2() {
    GameList list = new GameList();
    if (list.toString().equals("END")) {//check the end to toSting method
      return true;
    }
    return false;
  }
}
