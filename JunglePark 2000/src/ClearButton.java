//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ClearButton
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
 * This class represents a clear button in the Jungle Park application It extends Button class
 * 
 * @author Yida Wu
 */
public class ClearButton extends Button {
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park); //father class constructor
    this.label = "Clear Park"; 
    // the button name
  }

  /**
   * check the mouse is press this button or not. If pressed, it will clear the all animal object in
   * the program.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      processing.listGUI.clear();
      //only clear animals
    }
  }

}
