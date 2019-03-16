/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ASCII ART
// Files: DrawingStack.java, DrawingStackIterator.java, DrawingChange.java, Canvas.java,
// AsciiArt.java, and AsciiTest.java
// Course: CS 300, Fall 2018
//
// Author: Yuanbo Zhang
// Email: yzhang2325@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email: 
// Partner Lecturer's Name: Gary Dahl
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
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * This class is a direct iterator of the stack, starting at the given the given node. This class
 * implements the Iterator<DrawingChange> interface
 */
public class DrawingStackIterator<T> implements Iterator<DrawingChange> {
  private Node<DrawingChange> node; // a stack using a chain-of-linked-nodes

  /**
   * Constructor of the iterator, creating an iterator starting at the given node.
   * 
   * @param a node containing DrawingChange type data
   */
  public DrawingStackIterator(Node<DrawingChange> node) {
    this.node = node; // set the beginning node to the given node
  }

  /**
   * Returns true if this node has a following node.
   * 
   * @return true if this node has a following node, false otherwise
   */
  @Override
  public boolean hasNext() {
    if (node == null) // ensure that the node is not null first to avoid a nullPointerException
      return false;
    if (node.getData() == null)
      return false;

    return true;
  }

  /**
   * Returns the data stored in the current node, then change the pointer to the next node.
   * 
   * @return DrawingChange type data stored in the current node
   */
  @Override
  public DrawingChange next() {
    if(!hasNext())
      return null;
    DrawingChange now = node.getData(); // store the data here
    node = node.getNext();
    return now;
  }

}
