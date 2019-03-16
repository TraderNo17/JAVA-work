/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ASCII ART
// Files: DrawingStack.java, DrawingStackIterator.java, DrawingChange.java, Canvas.java,
// AsciiArt.java, and AsciiTest.java
// Course: CS 300, Fall 2018
//
// Author: Yida Wu
// Email: ywu479@wisc.edu
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

import java.util.Scanner;

/**
 * this is AsciiArt class, this class is driver.
 * 
 * @author Yida
 *
 */
public class AsciiArt {
  public static Scanner sc = new Scanner(System.in);  //scanner of the program
  public static Canvas canvas; // the canvas for drawing

  /**
   * this method creates interface for the whole program
   */
  public static void printInterface() {
    System.out.print("======== MENU ========\n" + "[1] Create a new canvas\n"
        + "[2] Draw a character\n" + "[3] Undo drawing\n" + "[4] Redo drawing\n"
        + "[5] Show current canvas\n" + "[6] Show drawing history\n" + "[7] Exit\n" + "> ");
  }

  /**
   * this method check the user input and prompt correct action accordingly.
   * 
   * @param command command of user input
   * @return true after method implemented
   */
  public static boolean processCommand(String command) {
    switch (command) { // choose the correct method to perform
      case "1":
        System.out.print("Width > ");
        int width = Integer.parseInt(sc.nextLine());
        System.out.print("Height > ");
        int height = Integer.parseInt(sc.nextLine());
        if (width <= 0 || height <= 0) {
          System.out.println("Width or height of the canvas cannot be 0 or less!");
          break;
        }
        canvas = new Canvas(width, height);
        break;
      case "2":
        System.out.print("Row > ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Col > ");
        int col = Integer.parseInt(sc.nextLine());
        System.out.print("Character > ");
        char c = sc.nextLine().charAt(0);
        try {
          canvas.draw(row, col, c);
        } catch (IllegalArgumentException e) {
          System.out.println("This point is outside of the canvas area!");
        }
        break;
      case "3":
        canvas.undo(); // perform undo in canvas
        break;
      case "4":
        canvas.redo(); // perform redo in canvas
        break;
      case "5":
        System.out.println(canvas.toString()); // print the canvas
        break;
      case "6":
        canvas.printHistory(); // perform print history in canvas
        break;
      case "7":
        System.out.println("Bye!"); // end of the program
        return false;

      default:
        System.out.println("Invalid command!"); // reminder of invalid input
        break;
    }
    return true;
  }

  /**
   * this is main method to start the program
   * 
   */
  public static void main(String[] args) {

    while (true) {
      printInterface(); // start driver
      String command = sc.nextLine(); // scan the next line
      if (!processCommand(command))
        break;
    }

    sc.close();
  }
}
