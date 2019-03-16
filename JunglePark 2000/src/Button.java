//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Button
// Files: AddAnimalButton.java,Animal.java,Button.java,ClearButton.java,Deer.java,JunglePark.java,
// JungleParkTests.java,ParkGUI.java,Tiger.java
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
// This a super class for any Button that can be added to a PApplet application
// This class implements the ParkGUI interface
// TODO You MUST comment well this code
// TODO ADD File header, Javadoc class header, Javadoc method header to every method, and in-line
// commenting

/**
 * This class represents a button in the Jungle Park application It implements the interface ParkGUI
 * 
 * @author Mouna Kacem
 */
public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
                            // the display window
  protected String label; // text/label that represents the button

  /**
   * Creates a new Button object positioned at a given position of the display window
   * 
   * @param X    x-coordinate of the button in the display window
   * @param Y    y-coordinate of the button in the display window
   * @param park PApplet object that represents the display window
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing; 
    // place the button in correct location
    this.position = new float[2];
    this.position[0] = x;
    this.position[1] = y;
    this.label = "Button";
  }

  /**
   * draw the picture through the whole program process.
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * check the mouse is pressed or not.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) //created for test
      System.out.println("A button was pressed.");
  }

  /**
   * empty class to check the mouse is checked or not.
   */
  @Override
  public void mouseReleased() {} //empty class

  /**
   * check the mouse is over or not.
   * 
   * @return true if mouse is over that object, false for mouse is not over
   */
  @Override
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2) // the area to check whether the
                                                                   // mouse is over or not
      return true;
    return false;
  }
}
