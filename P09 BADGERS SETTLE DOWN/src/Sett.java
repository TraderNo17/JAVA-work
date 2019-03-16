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

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class represents a Sett, where a group of Badgers live together. Each Sett is organized as a
 * BST of Badger nodes.
 * 
 * @author Yida
 */
public class Sett {
  private Badger topBadger;

  /**
   * Constructs an empty Sett.
   * 
   */
  public Sett() {
    this.topBadger = null;
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    this.topBadger = null;
  } // Empties this Sett, to no longer contain any Badgers.

  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return number counted.
   */
  public int countBadger() {
    if (this.topBadger == null) {
      return 0;
    }
    return countHelper(this.topBadger) + 1;
  } // Counts how many Badgers live in this Sett.

  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * 
   * @param current the current badger
   * @return the recursive step
   */
  private int countHelper(Badger current) {
    if (current.getLeftLowerNeighbor() != null && current.getRightLowerNeighbor() != null) {
      return countHelper(current.getLeftLowerNeighbor())
          + countHelper(current.getRightLowerNeighbor()) + 2;
    } else if (current.getLeftLowerNeighbor() != null) {
      return countHelper(current.getLeftLowerNeighbor()) + 1;
    } else if (current.getRightLowerNeighbor() != null) {
      return countHelper(current.getRightLowerNeighbor()) + 1;
    } else {
      return 0;
    }
  }// This recursive helper method is used to help count the number of Badgers in this Sett.

  /**
   * Finds a Badger of a specified size in this Sett.
   * 
   * @param size the size of target badger
   * @return the recursive step
   * @throws NoSuchElementException when find same badger.
   */
  public Badger findBadger(int size) throws NoSuchElementException {
    return findHelper(this.topBadger, size);
  }// Finds a Badger of a specified size in this Sett.

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * @param current the current badger
   * @param size    the size of target badger
   * @return the recursive step
   * @throws NoSuchElementException when find same badger.
   */
  private Badger findHelper(Badger current, int size) throws NoSuchElementException {
    if (current == null) {
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size " + size + " in the sett");
    } else if (current.getSize() > size) {
      return findHelper(current.getLeftLowerNeighbor(), size);
    } else if (current.getSize() < size) {
      return findHelper(current.getRightLowerNeighbor(), size);
    } else {
      return current;
    }
  } // This recursive helper method is used to help find a Badger within this Sett.

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in
   * the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @Param allBadger the list of badgers
   * @return allBadger.
   */
  public java.util.List<Badger> getAllBadgers() {
    ArrayList<Badger> allBadgers = new ArrayList<Badger>();
    getAllHelper(this.topBadger, allBadgers);
    return allBadgers;
  }// Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one
   // in the front (at index zero), through the largest one at the end (at index size-1).


  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param current    the current badger.
   * @param allBadgers the badger list.
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {
    if (current == null) {
      return;
    }
    getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
    allBadgers.add(current);
    getAllHelper(current.getRightLowerNeighbor(), allBadgers);
  }// This recursive helper method is used to help collect the Badgers within this Sett into a List.

  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   * node.
   * 
   * @return the height of binart search tree.
   */
  public int getHeight() {
    return getHeightHelper(this.topBadger);
  }// Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   // node.

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current the current badger.
   * @return recursive step.
   */
  private int getHeightHelper(Badger current) {
    if (current == null) {
      return 0;
    } else {
      int left = getHeightHelper(current.getLeftLowerNeighbor());
      int right = getHeightHelper(current.getRightLowerNeighbor());
      return 1 + Math.max(left, right);
    }
  }// This recursive helper method is used to help compute the height of this Sett.

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @param temp the target badger.
   * @return the largest badger.
   */
  public Badger getLargestBadger() {
    Badger temp = this.topBadger;
    while (temp.getRightLowerNeighbor() != null) {
      temp = temp.getRightLowerNeighbor();
    }
    return temp;
  }// Retrieves the largest Badger living in this Sett.

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return the top badger.
   */
  public Badger getTopBadger() {
    return this.topBadger;
  }// Retrieve the top Badger within this Sett (the one that was settled first).

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true when it is empty, vise vase
   */
  public boolean isEmpty() {
    if (this.topBadger != null) {
      return false;
    } else {
      return true;
    }
  }// Checks whether this Sett is empty.

  /**
   * Creates a new Badger object with the specified size, and inserts them into this Sett (BST).
   * 
   * @Param newBadger the badger to settle
   * @param size the size of settled badger
   * @throws IllegalArgumentException when there is a badger with the same size.
   */
  public void settleBadger(int size) throws IllegalArgumentException {
    Badger newBadger = new Badger(size);
    if (this.topBadger == null) {
      this.topBadger = newBadger;
    } else {
      settleHelper(this.topBadger, newBadger);
    }
  }// Creates a new Badger object with the specified size, and inserts them into this Sett (BST).

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * @param current   the current badger
   * @param newBadger the badger to settle
   * @throws IllegalArgumentException when there is a badger with same size.
   */
  private void settleHelper(Badger current, Badger newBadger) throws IllegalArgumentException {
    if (newBadger.getSize() > current.getSize()) {
      if (current.getRightLowerNeighbor() == null) {
        current.setRightLowerNeighbor(newBadger);
      } else {
        settleHelper(current.getRightLowerNeighbor(), newBadger);
      }
    } else if (newBadger.getSize() < current.getSize()) {
      if (current.getLeftLowerNeighbor() == null) {
        current.setLeftLowerNeighbor(newBadger);
      } else {
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
      }
    } else {
      throw new IllegalArgumentException("WARNING: failed to settle the badger with size "
          + newBadger.getSize() + ", as there is already a badger with the same size in this sett");
    }
  }
  // This recursive helper method is used to help settle a new Badger within this Sett.
}
