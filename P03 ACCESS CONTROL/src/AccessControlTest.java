//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AccessControlTest
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
 * The class User contains seven methods to call. The function of this class is to the program
 * AccessControll.
 * 
 * testLogin1: test log in with bad name
 * <p>
 * testLogin2: test mornally log in
 * <p>
 * testLogin3: test bad username with default password
 * <p>
 * testAddUser1: test add user with no admin power
 * <p>
 * testAddUser2: test add same user
 * <p>
 * testRemoveUser: test remove user with no authority
 * <p>
 * changePassword: test change password
 */
public class AccessControlTest {
  /**
   * Testing main. Runs each test and prints which (if any) failed.
   */
  public static void main(String[] args) {
    int fails = 0;

    if (!testLogin1()) {
      System.out.println("testLogin1 [bad username] failed");
      fails++;
    }
    if (!testLogin2()) {
      System.out.println("testLogin2 [good login] failed");
      fails++;
    }
    if (!testLogin3()) {
      System.out.println("testLogin3 [bad username with default password] failed");
      fails++;
    }
    if (!testAddUser1()) {
      System.out.println("testAddUser1 [non-admin account add user] failed");
      fails++;
    }
    if (!testAddUser2()) {
      System.out.println("testAddUser2 [admin account add same-name user] failed");
      fails++;
    }
    if (!testRemoveUser()) {
      System.out.println("testRemoveUser [non-admin account remove a current user] failed");
      fails++;
    }
    if (!changePassword()) {
      System.out.println("changePassword [admin account change password] failed");
      fails++;
    }
    if (fails == 0)
      System.out.println("All tests passed!");
  }

  /**
   * This test tries to log in a user that doesn't exist
   * 
   * @param ac   initializes AccessControl
   * @param pw   is test the password
   * @param user test username
   * @return boolean test passed
   */
  public static boolean testLogin1() {
    AccessControl ac = new AccessControl();
    String user = "probablyNotInTheSystem1234";
    String pw = "password";
    return !ac.isValidLogin(user, pw); // isValidLogin should return false
  }

  /**
   * This test tries to log in a user that currently exist
   * 
   * @param ac   initializes AccessControl
   * @param user is the username
   * @param pw   test password
   * @return boolean test passed
   */
  public static boolean testLogin2() {
    AccessControl ac = new AccessControl();
    ac.setCurrentUser("admin");
    ac.addUser("testuser");
    String user = "testuser";
    String pw = "changeme";
    return ac.isValidLogin(user, pw); // isValidLogin should return ture
  }

  /**
   * This test tries to log in a user, using default password, that doesn't exist
   * 
   * @param ac   initializes AccessControl
   * @param user is the username
   * @param pw   is the password
   * @return boolean test passed
   */
  public static boolean testLogin3() {
    AccessControl ac = new AccessControl();
    String user = "probablyNotInTheSystem1234";
    String pw = "changeme";
    return !ac.isValidLogin(user, pw); // isValidLogin should return false
  }

  /**
   * Create a new AccessControl and do not log in an admin. Verify that addUser(String username)
   * returns false and that the new user is not added.
   * 
   * @param ac   initializes AccessControl
   * @param user is the username used to add a user
   * @addUserReport is the test result of the method
   * @return boolean test passed
   */
  public static boolean testAddUser1() {
    AccessControl ac = new AccessControl();
    String user = "alexi";
    boolean addUserReport = ac.addUser(user);
    if (addUserReport)
      return false; // addUserReport should be false
    // Make sure user wasn't added anyway
    return !ac.isValidLogin(user, "changeme");
  }

  /**
   * Create a new AccessControl and log in an admin. Then add same username twice. Verify that
   * addUser(String username) returns false and that the new user is not added.
   * 
   * @param ac   initializes AccessControl
   * @param user is the username
   * @addUserReport is the test result of the method
   * @return boolean test passed
   */
  public static boolean testAddUser2() {
    AccessControl ac = new AccessControl();
    ac.setCurrentUser("admin");
    ac.addUser("alexi");
    String user = "alexi";
    boolean addUserReport = ac.addUser(user);
    if (addUserReport)
      return false; // addUserReport should be false
    // Make sure user wasn't added again anyway
    return ac.isValidLogin(user, "changeme");
  }

  /**
   * Create a new AccessControl and do not log in an admin. Verify that removeUser(String username)
   * returns false and that the admin user is not removed.
   * 
   * @param ac   initializes AccessControl
   * @param user is the admin username
   * @removeUserReport is the test result of the method
   * @return boolean test passed
   */
  public static boolean testRemoveUser() {
    AccessControl ac = new AccessControl();
    String user = "admin";
    boolean removeUserReport = ac.removeUser(user);
    if (removeUserReport)
      return false; // removeUserReport should be false
    // Make sure user wasn't removed anyway
    return !ac.isValidLogin(user, "changeme");
  }

  /**
   * Create a new AccessControl and do not log in an admin. Verify that resetPassword(String
   * username) returns false and that the admin password is not changed.
   * 
   * @param ac       initializes AccessControl
   * @param password is the login password
   * @param user     is the admin username
   * @changePasswordReport is the test result of the method
   * @return boolean test passed
   */
  public static boolean changePassword() {
    AccessControl ac = new AccessControl();
    String password = "root";
    String user = "admin";
    ac.setCurrentUser("admin");
    ac.resetPassword("admin");
    boolean changePasswordReport = ac.isValidLogin(user, password);
    if (changePasswordReport)
      return false; // changePasswordReport should be false
    // Make sure password wasn't changed anyway
    return ac.isValidLogin(user, "changeme");
  }
}
