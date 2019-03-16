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

import java.util.Iterator;

/**
 * This class represents an ASCII-art image. A canvas has properties like width, height, a
 * drawingArray to store the content of the canvas and undoStack and redoStack to realize the
 * function of undo and redo.
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D charater array to store the drawing

  private final DrawingStack undoStack; // previous changes for undo
  private final DrawingStack redoStack; // undone changes for redo

  /**
   * Constructor of the Canvas, create a canvas with a given size, and fill the canvas with spaces
   * 
   * @param width: width of the canvas
   * @param height: height of the canvas
   * @throws IllegalArgumentException if width or height is 0 or negative
   */
  public Canvas(int width, int height) throws IllegalArgumentException {
    // check valldity of the width and height
    if (width <= 0 || height <= 0)
      throw new IllegalArgumentException("Width or height of the canvas cannot be 0 or less!");

    // initialize the field
    this.width = width;
    this.height = height;
    undoStack = new DrawingStack<DrawingChange>();
    redoStack = new DrawingStack<DrawingChange>();
    drawingArray = new char[height][width];

    for (int i = 0; i < height; i++)
      for (int j = 0; j < width; j++)
        drawingArray[i][j] = ' ';
  }

  /**
   * Draw a character at the given position If that position is already marked with a different
   * character, overwrite it. After making a new change, add a matching DrawingChange to the
   * undoStack so that we can undo if needed. After making a new change, the redoStack should be
   * empty.
   * 
   * @param row: row of the point
   * @param col: column of the point
   * @param c: new character that is going to be drawn at the given point
   * @throws IllegalArgumentException if the drawing position is outside the canvas
   */
  public void draw(int row, int col, char c) throws IllegalArgumentException {
    if (row >= height || col >= width || row < 0 || col < 0)
      throw new IllegalArgumentException("This point is outside of the canvas area");
    DrawingChange change = new DrawingChange(row, col, drawingArray[row][col], c);
    undoStack.push(change); // add a Drawing Change to the undoStack
    while (!redoStack.isEmpty()) // clear undo stack
      redoStack.pop();
    drawingArray[row][col] = c; // draw some characters at the given positions
  }

  /**
   * Undo the most recent drawing change. Return true if successful. False otherwise. An undone
   * DrawingChange should be added to the redoStack so that we can redo if needed.
   * 
   * @return true if successfully undo, false otherwise
   */
  public boolean undo() {
    if (undoStack.isEmpty()) // if the stacks are empty, undo fail
      return false;
    DrawingChange change = (DrawingChange) undoStack.pop();
    redoStack.push(change); // An undone Drawing Change should be added to the redo Stack so that we
                            // can redo if needed.

    drawingArray[change.x][change.y] = change.prevChar; // implement the change to the canvas
    return true;
  }

  /**
   * Redo the most recent undone drawing change. Return true if successful. False otherwise. A
   * redone DrawingChange should be added to the undoStack so that we can undo again if needed.
   * 
   * @return true if successfully redo, false otherwise
   */
  public boolean redo() {
    if (redoStack.isEmpty()) // if the stacks is null, redo fail
      return false;
    DrawingChange change = (DrawingChange) redoStack.pop();
    undoStack.push(change); // A redone Drawing Change should be added to the undo Stack so that we
                            // could undo again if needed.

    drawingArray[change.x][change.y] = change.newChar; // implement the change to canvas
                                                       
    return true;
  }

  /**
   * Return a printable string version of the Canvas.
   * 
   * @return a printable string version of the Canvas.
   */
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder(); // use a StringBuilder to save running time
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++)
        res.append(drawingArray[i][j]);
      res.append('\n'); // add a new line by adding '\n'
    }
    return res.toString();
  }

  /**
   * Print the drawing history by iterating through the undoStack and print every change in
   * descending order
   */
  public void printHistory() {
    Iterator<DrawingChange> iterator = undoStack.iterator(); // get the iterator of undoStack
    int size = undoStack.size(); // get the size to print the changes in descending order
    for (int i = size; i >= 0; i--) {
      DrawingChange now = iterator.next();
      System.out.println(i + ". draw '" + now.newChar + "' on (" + now.x + "," + now.y + ")");
    }
  }

  /**
   * Accessor of the drawingArray
   * 
   * @return drawingArray
   */
  public char[][] getDrawingArray() {
    return drawingArray;
  }
}
