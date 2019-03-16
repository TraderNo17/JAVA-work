//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: GameNode
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
 * This class creates game node which will be used in following codes. It is the base of the whole
 * program and it creates like Linked nodes.
 * 
 * @author Yida Wu
 */
public class GameNode {
  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /**
   * The method initializes a new game node.
   * 
   * @param rng
   */
  public GameNode(Random rng) {
    this.number = rng.nextInt(9) + 1;
    this.next = null;
  } // initializes number to random 1-9 value, and next to null

  /**
   * the method returns a the number of this game node.
   * 
   * @return the number of node
   */
  public int getNumber() {
    return this.number;
  } // accessor for the number field

  /**
   * this method get the next node after this
   * 
   * @return get next node
   */
  public GameNode getNext() {
    return this.next;
  } // accessor for the next field

  /**
   * this program set the next node
   * 
   * @param next
   */
  public void setNext(GameNode next) {
    this.next = next;
  } // mutator for the next field

  /**
   * Calling the applyOperator() method on a GameNode changes that nodes number and next fields. The
   * new number for this node is calculated by applying the provided operator to this node's number
   * (the first operand), and the next node's number (the second operand). The new next reference
   * for this node should be copied from the next reference of the following node in the list so
   * that the following node is effectively removed from the list.
   * 
   * @param operator the input operator
   */
  public void applyOperator(GameOperator operator) {
    this.number = operator.apply(this.number, next.getNumber());
    this.setNext(next.getNext()); // connect the node
  } 
}
