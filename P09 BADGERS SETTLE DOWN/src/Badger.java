//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BADGERS SETTLE DOWN
// Files: Bsadger.java,BadgerSettleDown.java,P9Tests.java,Sett.java
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
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents
 * a single node within a BST (known as a Sett).
 * 
 * @author Yida
 */
public class Badger {
  private Badger leftLowerNeighbor; // left lower neighbor
  private Badger rightLowerNeighbor;// right lower neighbor
  private int size;// size of badger

  /**
   * Creates a new Badger with specified size.
   * 
   * @param size the size of badger
   */
  public Badger(int size) {
    this.size = size; // set the class size
  }

  /**
   * Retrieves neighboring badger that is smaller than this one.
   * 
   * @return neighboring badger that is smaller than this one
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;//return the left child
  }

  /**
   * Retrieves neighboring badger that is larger than this one.
   * 
   * @return neighboring badger that is larger than this one.
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor; //return the right child
  }

  /**
   * Retrieves the size of this badger.
   * 
   * @return size
   */
  public int getSize() {
    return this.size; // change the size in the class
  }

  /**
   * Changes this badger's lower left neighbor.
   * 
   * @param badger the current badger
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger; //change operation 
  }

  /**
   * Changes this badger's lower right neighbor.
   * 
   * @param badger the current badger
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger; //change badger
  }
}
