//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AccessControl
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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class AccessControl contains twelve methods (except main method) for users to use. The
 * function of this class is to build both drive and core part of access control system.
 * 
 * isValidLogin: check the user login status
 * <p>
 * changePassword: changes user's password.
 * <p>
 * logout: let user log out
 * <p>
 * setCurrentUser: set the user in opration
 * <p>
 * addUser: this contains two methods with different parameter. One is add user with default admin
 * status; another is add user by input admin status command
 * <p>
 * removeUser: remove a user
 * <p>
 * giveAdmin: give a user the admin power
 * <p>
 * takeAdmin: remove onr user's admin power
 * <p>
 * resetPassword: reset the password
 * <p>
 * loginScreen: starts the login screen
 * <p>
 * sessionScreen: the core drive
 * 
 * @param users            is a ArrayList of users group
 * @param currentUser      determines which user is using the program
 * @param DEFAULT_PASSWORD is the default password for when a user created
 */
public class AccessControl {
  private static ArrayList<User> users; // An ArrayList of valid users.
  private User currentUser; // Who is currently logged in, if anyone?
  private static final String DEFAULT_PASSWORD = "changeme";
  // Default password given to
  // new users or when we reset a user's password.

  /**
   * Constructor of the class, initiate some values
   */
  public AccessControl() {
    users = new ArrayList<User>();
    users.add(new User("admin", "root", true));
    currentUser = null;
  } // A no-parameter constructor


  /**
   * main method to start the program
   * 
   * @param ac     is a new user array
   * @param userIn is a scanner for load input
   */
  public static void main(String[] args) {
    AccessControl ac = new AccessControl();
    // If we have any persistent information to lead
    // this is where we load it.
    Scanner userIn = new Scanner(System.in);
    ac.loginScreen(userIn);
  }

  /**
   * check whether user log in correctly
   * 
   * @see User.isValidLogin
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username) && users.get(i).isValidLogin(password)) {
        return true;
      }
    }
    return false;
  }
  // Report whether a
  // given username/password pair is a valid login
  // If we have any persistent information to lead
  // this is where we load it.

  /**
   * check whether user type the correct password
   * 
   * @see User.setPassword
   */
  public void changePassword(String newPassword) {
    currentUser.setPassword(newPassword);
  } // Change the current user's password


  /**
   * to log out
   */
  public void logout() {
    currentUser = null;
  } // Log out the current user

  /**
   * get the username
   * 
   * @see User.getUsername
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
      }
    }
  } // A mutator you can use to write tests
    // without simulating user input

  /**
   * add user with 1 parameter
   * 
   * @see User.getUsername
   * @see User.getIsAdmin
   */
  public boolean addUser(String username) {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        return false;
      }
    }
    users.add(new User(username, DEFAULT_PASSWORD, false));
    return true;
  } // Create a new user
  // With the default password and isAdmin==false

  /**
   * add user with 2 parameter
   * 
   * @see User.getUsername
   * @see User.getIsAdmin
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        return false;
      }
    }
    users.add(new User(username, DEFAULT_PASSWORD, isAdmin));
    return true;
  } // Create a new user
  // and specify their admin status

  /**
   * remove a user
   * 
   * @see User.getUsername
   * @see User.getIsAdmin
   */
  public boolean removeUser(String username) {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.remove(i);
        return true;
      }
    }
    return false;
  } // Remove a user (names should be unique)

  /**
   * give a user admin power
   * 
   * @see User.getUsername
   * @see User.getIsAdmin
   * @see User.setIsAdmin
   */
  public boolean giveAdmin(String username) {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(true);
        return true;
      }
    }
    return false;
  } // Give a user admin power

  /**
   * take a user's admin power
   * 
   * @see User.getUsername
   * @see User.getIsAdmin
   * @see User.setIsAdmin
   */
  public boolean takeAdmin(String username) {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(false);
        return true;
      }
    }
    return false;
  } // Remove a user's admin power


  /**
   * reset a password
   * 
   * @see User.getUsername
   * @see User.getIsAdmin
   * @see User.setPassword
   */
  public boolean resetPassword(String username) {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setPassword(DEFAULT_PASSWORD);
        return true;
      }
    }
    return false;
  } // Reset a user's password

  /**
   * starts a login screen
   * 
   * @param userInputScanner is a scanner
   * @param username         is a field to write username
   * @param password         is a field to write password
   */
  public void loginScreen(Scanner userInputScanner) {
    String username;
    String password;
    while (true) {
      System.out.println("Please enter your username");
      username = userInputScanner.next();
      System.out.println("Please enter your password");
      password = userInputScanner.next();
      if (isValidLogin(username, password)) {
        sessionScreen(username, userInputScanner);
      } else {
        System.out.println("Invalid login");
      }
    }
  } // Main driver loop.
  // Prompt the user for login information
  // calls the isValidLogin method
  // If the login is valid, call the sessionScreen method


  /**
   * starts the session screen
   * 
   * @param username         current user's name
   * @param userInputScanner is a scanner
   * @param temp             is field for temporarily store data
   * @param strArray         is a field to store processed data
   */
  public void sessionScreen(String username, Scanner userInputScanner) {
    String temp;
    String[] strArray;
    setCurrentUser(username);
    System.out.println("Now you have logged in, please follow following commands:");
    System.out.println("logout\r\n" + "newpw [newpassword]\r\n" + "adduser [username]\r\n"
        + "adduser [username] [true or false]\r\n" + "rmuser [username]\r\n"
        + "giveadmin [username]\r\n" + "rmadmin [username]\r\n" + "resetpw [username]");
    while (currentUser != null) {
      System.out.println("Please enter you command");
      temp = userInputScanner.nextLine();
      strArray = temp.trim().split("\\s+");
      for (int i = 0; i < strArray.length; i++) {
        switch (strArray[i]) {
          case "logout":
            logout();
            System.out.println("You have logged out");
            break;
          case "newpw":
            currentUser.setPassword(strArray[i + 1]);
            System.out.println("Done");
            i++;
            break;
          case "adduser":
            System.out.println(strArray[i]);
            if (i + 2 < strArray.length
                && (strArray[i + 2].equals("true") || strArray[i + 2].equals("false"))) {
              addUser(strArray[i + 1], Boolean.getBoolean(strArray[i + 2]));
              i += 2;
              System.out.println(111);
            } else {
              addUser(strArray[i + 1]);
              i++;
            }
            System.out.println("Done");
            break;
          case "rmuser":
            removeUser(strArray[i + 1]);
            System.out.println("Done");
            i++;
            break;
          case "giveadmin":
            giveAdmin(strArray[i + 1]);
            System.out.println("Done");
            i++;
            break;
          case "rmadmin":
            takeAdmin(strArray[i + 1]);
            System.out.println("Done");
            i++;
            break;
          case "resetpw":
            resetPassword(strArray[i + 1]);
            System.out.println("Done");
            i++;
            break;
          default:
            System.out.println("Invalid command");
        }
      }
    }
  }
  // Set the currentUser
  // Allows them to changePassword or logout
  // If they are an admin, gives access to admin methods
}
