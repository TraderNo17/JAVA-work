//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Deer
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
 * This class create a deer in the Jungle Park application It extends animal class.
 * 
 * @author Yida Wu
 */
public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer

  /**
   * Creates a new Deer object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  // Constructor that creates a new Deer object positioned at a random position of the display
  // window
  public Deer(JunglePark processing) {
    // Set Deer drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }

  /**
   * scan for whether there is a tiger in the scanRange
   * 
   * @param scanRange the range for deer to be threaten be a tiger
   * @return true is these is tiger threating a deer, false is these is no tiger around
   */
  // Checks if there is a threat (a Tiger for instance) at the neighborhood
  // scanRange is an integer that represents the range of the area to be scanned around the animal
  public boolean scanForThreat(int scanRange) {
    for (ParkGUI i : processing.listGUI) {
      if (i instanceof Tiger) {
        if (isClose((Tiger) i, scanRange))
          return true;
      }
    }
    return false;
  }


  /**
   * perform the action of a deer. if there is a tiger within SCAN_RANGE, the dear will report a
   * threat in its head.
   */
  // Defines the behavior of a Deer object in the Jungle park
  @Override
  public void action() {
    for (ParkGUI i : processing.listGUI) {
      if (i instanceof Tiger) {
        if (isClose((Tiger) i, SCAN_RANGE)) {
          this.processing.fill(0); // specify font color: black
          this.processing.text("THREAT!", this.getPositionX(),
              this.getPositionY() - this.image.height / 2 - 4);
        }
      }
    }
  }
}
