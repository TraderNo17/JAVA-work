//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AddAnimalButton
// Files: AddAnimalButton.java,Animal.java,Button.java,ClearButton.java,Deer.java,JunglePark.java,
//        JungleParkTests.java,ParkGUI.java,Tiger.java
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
 * This class represents a button in the Jungle Park application It extends the class Button and
 * implements the interface ParkGUI
 * 
 * @author Mouna Kacem
 */
public class AddAnimalButton extends Button implements ParkGUI {
  private String type; // type of the animal to add

  /**
   * Creates a new Button object positioned at a given position of the display window
   * 
   * @param type the type of button
   * @param X    x-coordinate of the button in the display window
   * @param Y    y-coordinate of the button in the display window
   * @param park PApplet object that represents the display window
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park); //Perform the constructor from super class
    this.type = type.toLowerCase();
    this.label = "Add " + type; // determine the type of the animal
  }

  /**
   * Check which button is pressed and perform that button action.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          // TODO create a new Tiger and add it to the JunglePark
          processing.listGUI.add(new Tiger(processing));
          break;
        case "deer":
          // TODO create a new Deer and add it to the JunglePark
          processing.listGUI.add(new Deer(processing));
          break;
      }
    }
  }
}
