//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Tiger
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
 * This class represents a Tiger in the JunglePark application
 * 
 * @author Yida Wu
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far

  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
    deerEatenCount = 0;
  }


  /**
   * Tiger's behavior in the Jungle Park Scans for food at the neighborhood of the current tiger. If
   * the Tiger founds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {
    // TO DO scan for food (aka deer) and hop on it if any.
    for (int i = 0; i < processing.listGUI.size(); i++) {
      ParkGUI j = processing.listGUI.get(i);
      if (j instanceof Deer) {
        if (isClose((Deer) j, SCAN_RANGE)) {
          if (!isDragging()) {
            hop(((Deer) j));
            i--;
          }
        }
      }
    }
    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }


  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }

  /**
   * Calculate the total deers eaten.
   * 
   * @return deerEatenCount the number of the deer eaten.
   */
  public int getDeerEatenCount() {
    return deerEatenCount; 
  }

  /**
   * the hop action to eat a deer and tiger will replace the position of eaten deer and add one
   * deerEsatenCount.
   * 
   * @param food the targeted deer by the tiger, which will be eaten later.
   */
  public void hop(Deer food) {
    this.setPositionX(food.getPositionX());//get the food's x location    
    this.setPositionY(food.getPositionY());//get the food's y location
    processing.listGUI.remove(food);
    deerEatenCount++;//add the number of food eaten
  }
}
