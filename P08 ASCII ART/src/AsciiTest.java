/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ASCII ART
// Files: DrawingStack.java, DrawingStackIterator.java, DrawingChange.java, Canvas.java,
// AsciiArt.java, and AsciiTest.java
// Course: CS 300, Fall 2018
//
// Author:          Yida Wu
// Email:           ywu479@wisc.edu
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

import java.util.ArrayList;

/**
 * this class is test class to test the program correctness.
 * 
 * @author Yida
 *
 */
public class AsciiTest {
  
  /** 
   * this method tests the correct of stack push and peek
   * 
   * @param stack the stack for drwing changes
   * @Param change the change of a drawing
   * @return true the test is correct
   */
  public static boolean testStackPushPeek() {
    DrawingStack<DrawingChange> stack = new DrawingStack<DrawingChange>(); //create stack
    DrawingChange change = new DrawingChange(1, 2, 'X', 'Y'); // create change
    stack.push(change);
    if (change == stack.peek())
      return true;
    return false;
  }

  /**
   * this is a test method for canvas
   * 
   * @param canvas the canvas used to test
   * @return true when test is passed
   */
  public static boolean runStackTestSuite() {
    Canvas canvas = new Canvas(4, 4);
    try {
      canvas.draw(0, 0, 'X'); // Current character at (0, 0): X
      canvas.draw(0, 0, 'Y'); // Current character at (0, 0): Y
      canvas.draw(0, 0, 'Z'); // Current character at (0, 0): Z
      canvas.undo(); // Undo succeed, current character at (0, 0): Y
      canvas.undo(); // Undo succeed, current character at (0, 0): X
      if (canvas.getDrawingArray()[0][0] != 'X')
        return false;
      canvas.redo(); // Redo succeed, current character at (0, 0): Y
      if (canvas.getDrawingArray()[0][0] != 'Y')
        return false;
      canvas.redo(); // Redo succeed, current character at (0, 0): Z
      if (canvas.getDrawingArray()[0][0] != 'Z')
        return false;
      canvas.redo(); // Redo fail, current character at (0, 0): Z
      if (canvas.getDrawingArray()[0][0] != 'Z')
        return false;
      canvas.undo(); // Undo succeed, current character at (0, 0): Y
      canvas.undo(); // Undo succeed, current character at (0, 0): X
      if (canvas.getDrawingArray()[0][0] != 'X')
        return false;
      canvas.draw(0, 0, 'T'); // redoStack is cleared, current character at (0, 0): T
      canvas.redo(); // Redo should fail, current character at (0, 0): T
      if (canvas.getDrawingArray()[0][0] != 'T')
        return false;
      canvas.undo(); // Undo should succeed, current character at (0, 0): X
      if (canvas.getDrawingArray()[0][0] != 'X')
        return false;
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  /**
   * Testing main. Runs each test and prints which (if any) failed. If no problem occurs, print a
   * single line showing "All tests passed!".
   */
  public static void main(String[] args) {
    int fails = 0;
    if (!testStackPushPeek()) {
      System.out.println("testStackPushPeek failed");
      fails++;
    }
    if (!runStackTestSuite()) {
      System.out.println("runStackTestSuite failed");
      fails++;
    }
    // If no error occurs, print a single line showing "All tests passed!".
    if (fails == 0)
      System.out.println("All tests passed!");
  }
}
