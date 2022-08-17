package utility;

import dto.BaseClass;
import example.utility.SingletonDesignPatternExampleUtility;
import jdbc.dto.JdbcConnection;
import jdbc.dto.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;

public class InitializeUtility extends BaseClass {

  public static int initialize() {
    System.out.println("***************");
    System.out.println("This is a sample application to see how Singleton Design Pattern is implemented in Java !");
    System.out.println("Please select your choice:");
    System.out.println("1. See basic example of Singleton Design Pattern works in Java");
    System.out.println("2. Run an online example for a JDBC Connection created with Singleton Design Pattern");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static void runSingletonDesignPatternExample() {
    try {
      Object singletonDesignExampleClass = SingletonDesignPatternExampleUtility.class.getDeclaredConstructor().newInstance();
      Method method = singletonDesignExampleClass.getClass().getDeclaredMethod("runExample");
      method.invoke(singletonDesignExampleClass);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }
  }

  public static void runJdbcConnectionExample() throws SQLException {
    System.out.println("***************");
    System.out.println("Select what you want to do in the database, insert a new user or select a user by username or delete a user by username !");
    System.out.println("1. Get a User by Username");
    System.out.println("2. Insert a New User");
    System.out.println("3. Delete a User by Username");
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();

    JdbcConnection jdbcConnection = JdbcConnection.getInstance();

    switch (choice) {
      case 1: {
        getUserOperation(scanner, jdbcConnection);
      } break;
      case 2: {
        insertUserMethod(scanner, jdbcConnection);
      } break;
      case 3: {
        deleteUserOperation(scanner, jdbcConnection);
      } break;
      default: {
        System.out.print("Not a valid option !!!");
      }
    }

    scanner.close();
  }

  private static void getUserOperation(Scanner scanner, JdbcConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to search: ");
    String username = scanner.next();
    User user = jdbcConnection.getUser(username);
    System.out.println(String.format("The username is %s and the password is %s !!!", user.getUsername(), user.getPassword()));
  }

  private static void insertUserMethod(Scanner scanner, JdbcConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to create: ");
    String username = scanner.next();
    System.out.print("Enter the password for the username: ");
    String password = scanner.next();
    jdbcConnection.insertUser(new User(username, password));
  }

  private static void deleteUserOperation(Scanner scanner, JdbcConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to delete: ");
    String username = scanner.next();
    jdbcConnection.deleteUser(username);
  }
}
