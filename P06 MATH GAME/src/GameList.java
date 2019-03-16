//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: GameList
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
/**
 * this method creates a list to store the nodes in list.
 * 
 * @author Yida Wu
 */
public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  /**
   * initiate the list to null
   */
  public GameList() {
    this.list = null;
  } // initializes list to start out empty

  /**
   * add a node to the list
   * 
   * @param newNode the new dame node
   */
  public void addNode(GameNode newNode) {
    if (list == null) {
      list = newNode;
    } else {
      GameNode temp = list;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
  } // adds the new node to the end of this list

  /**
   * to check whether this number exsts in the list
   * 
   * @param temp   temporarily to store the node
   * @param number the number waited to check
   * @return true is these is the number, false otherwise
   */
  public boolean contains(int number) {
    GameNode temp = list;
    if (list == null) {
      return false;
    }
    while (true) {
      if (temp.getNumber() == number) {
        return true;
      } else if (temp.getNext() == null) {
        return false;
      }
      temp = temp.getNext();
    }
  } // only returns true when this list contains a node with
    // the specified number

  /**
   * this method override the toString method
   * 
   * @param end    end string
   * @param symbol the connection symbol
   * @param s      the storage
   * @see java.lang.Object#toString()
   */
  public String toString() {
    String end = "END";
    String symbol = " -> ";
    String s = "";
    GameNode temp = list;
    if (list == null) {
      return end;
    }
    while (temp != null) {
      s = s + temp.getNumber() + symbol;
      temp = temp.getNext();
    }
    return s + end;
  } // returns a string with each number in the list separated by " -> "s,
    // and ending with " -> END"

  /**
   * this method applies the operator and calculate the result.
   * 
   * @param number   the target number
   * @param operator the target oprator
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {// (described below)
    GameNode temp = list;
    while (temp != null) { //loop for while the object is not null
      if (temp.getNumber() == number) {
        temp.applyOperator(operator); //calculate the result
        break;
      } else {
        temp = temp.getNext();//track the node progress
      }
    }
  }
}


