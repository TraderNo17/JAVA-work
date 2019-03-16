//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: User
// Files: User.java,AccessControl.java,AccessControlTest.java
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
 * The class User contains several methods to call. The function of this class is to return results
 * of different tests.
 * 
 * isValidLogin: verify whether user log in validly
 * <p>
 * getUsername: retrieve username
 * <p>
 * getIsAdmin: check the user power
 * <p>
 * setPassword: set the password
 * <p>
 * setIsAdmin: set the admin status
 * 
 * @param USERNAME is user's username
 * @param pawword is user's password
 * @param isAdmin is user status
 */
public class User {
  private final String USERNAME; // The user's name
  private String password; // The user's password
  private boolean isAdmin; // Whether or not the user has Admin powers

  /**
   * Constructor of the class.
   * 
   * @param username input username.
   * @param password input password.
   * @param isAdmin  indicates whether the user is administrator.
   */
  public User(String username, String password, boolean isAdmin) {
    USERNAME = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }
  // Creates a new user with the given password and admin status

  /**
   * to verify the password correct or not
   * 
   * @param password a password which is need to be verified.
   * @return the results of two tests.
   */
  public boolean isValidLogin(String password) {
    if (this.password.equals(password)) {
      return true;
    } else {
      return false;
    }
  } // Report whether the password is correct

  /**
   * to return the username.
   * 
   * @return the username of current user.
   */
  public String getUsername() {
    return USERNAME;
  } // Return the user's name

  /**
   * to check whether user has admin power
   * 
   * @return the power of the user
   */
  public boolean getIsAdmin() {
    return isAdmin;
  } // Report whether the user is an admin

  /**
   * to reset the password
   * 
   * @param password is password input
   */
  public void setPassword(String password) {
    this.password = password;
  } // Set the new password

  /**
   * to change a status of a user
   * 
   * @param isAdmin power limit input
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  } // Set the new admin status
}
