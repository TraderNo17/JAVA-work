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
 * this method tests the funcationality of of differnt methods
 * 
 * @author Yida
 */
public class P9Tests {

  /**
   * the main method to start the program.
   */
  public static void main(String[] args) {
    if (runAllBadgerTests())
      System.out.println("1");
    if (runAllSettTests())
      System.out.println("2");
  }

  /**
   * to start the badger class test
   * 
   * @return true when all functions are good
   */
  public static boolean runAllBadgerTests() {
    return badgerConstructorTest() && badgerLeftTest() && badgerRightTest();
  } // returns true when all Badger tests pass

  /**
   * start the sett class test
   * 
   * @return true when no problem
   */
  public static boolean runAllSettTests() {
    return settConstructorTest() && settClearTest() && settCountTest() && settFindTest()
        && settListTest() && settHeightTest() && settLargestTest() && settTopTest()
        && settEmptyTest() && settSettleTest();
  } // returns true when all Sett tests pass

  /**
   * test the constructor of badger
   * 
   * @param badger the badger
   * @return true when it functions well
   */
  public static boolean badgerConstructorTest() {
    Badger badger = new Badger(20);
    if (badger.getSize() != 20) {
      return false;
    } else {
      return true; // when there is no problem
    }
  }

  /**
   * test the function of left child
   * 
   * @pram badger the badger
   * @return true when it functions well
   */
  public static boolean badgerLeftTest() {
    Badger badger = new Badger(20);
    if (badger.getLeftLowerNeighbor() != null) {
      return false;
    } else {
      return true; // when there is no problem
    }
  }

  /**
   * test the function of the right child
   * 
   * @param badger created badger
   * @return true when it functions well
   */
  public static boolean badgerRightTest() {
    Badger badger = new Badger(20);
    badger.setRightLowerNeighbor(new Badger(30));
    if (badger.getRightLowerNeighbor().getSize() != 30) {
      return false;
    } else {
      return true; // when there is no problem
    }
  }

  /**
   * test the functionality of sett constructor
   * 
   * @Param sett the new sett
   * @return true when it functions well
   */
  public static boolean settConstructorTest() {
    Sett sett = new Sett();
    if (sett.isEmpty()) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the functionality of clear method.
   * 
   * @param sett the new sett
   * @return true when it functions well
   */
  public static boolean settClearTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.clear();
    if (sett.isEmpty()) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the count method.
   * 
   * @param sett the new sett
   * @return true when it functions well
   */
  public static boolean settCountTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.settleBadger(31);
    if (sett.countBadger() == 2) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the find method
   * 
   * @param sett the new sett
   * @return true when it functions well
   */
  public static boolean settFindTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.settleBadger(31);
    if (sett.findBadger(20) == sett.getTopBadger()) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the list method
   * 
   * @Param sett the new settt
   * @return true when it functions well
   */
  public static boolean settListTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.settleBadger(31);
    if (sett.getAllBadgers().get(1).getSize() == 31) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the height method
   * 
   * @Param sett the new sett
   * @return true when it functions well
   */
  public static boolean settHeightTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.settleBadger(31);
    if (sett.getHeight() == 2) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the find largest method
   * 
   * @param sett the new sett
   * @return true when it functions well
   */
  public static boolean settLargestTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.settleBadger(31);
    if (sett.getLargestBadger().getSize() == 31) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the get top badger method.
   * 
   * @param sett the new sett
   * @return true when it functions well
   */
  public static boolean settTopTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    sett.settleBadger(31);
    if (sett.getTopBadger().getSize() == 20) {
      return true; // when there is no problem
    }
    return false;
  }

  /**
   * test the is empty method.
   * 
   * @param sett th new badger
   * @return true when it functions well
   */
  public static boolean settEmptyTest() {
    Sett sett = new Sett();
    if (sett.isEmpty()) {
      return true;
    } // when there is no problem
    return false;
  }

  /**
   * test the settle badger method.
   * 
   * @param sett the new sett
   * @return true when it functions well
   */
  public static boolean settSettleTest() {
    Sett sett = new Sett();
    sett.settleBadger(20);
    if (sett.getTopBadger().getSize() == 20) {
      return true; // when there is no problem
    }
    return false;
  }
}
