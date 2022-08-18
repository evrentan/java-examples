package utility;

import dto.BaseClass;
import example.utility.SingletonDesignPatternExampleUtility;
import jdbc.dto.JdbcConnection;
import jdbc.dto.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;

public class InitializeUtility extends BaseClass {

  /**
   * Initialize the first interaction of the application from command prompt
   * @return int that is the choice of the end user. 1 or 2
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static int initialize() {
    System.out.println("***************");
    System.out.println("This is a sample application to see how Singleton Design Pattern is implemented in Java !");
    System.out.println("Please select your choice:");
    System.out.println("1. See basic example of Singleton Design Pattern works in Java");
    System.out.println("2. Run an online example for a JDBC Connection created with Singleton Design Pattern");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  /**
   * Run Singleton Design Pattern Example that is the first selection from the end user
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static void runSingletonDesignPatternExample() {
    try {
      Object singletonDesignExampleClass = SingletonDesignPatternExampleUtility.class.getDeclaredConstructor().newInstance();
      Method method = singletonDesignExampleClass.getClass().getDeclaredMethod("runExample");
      method.invoke(singletonDesignExampleClass);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }
  }

  /**
   * Run JDBC Connection Example that is the second selection from the end user
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static void runJdbcConnectionExample() throws SQLException {


    JdbcConnection jdbcConnection = JdbcConnection.getInstance();

    while (true) {
      Scanner scanner = getUserChoice();
      int choice = scanner.nextInt();
      switch (choice) {
        case 1 -> getUserOperation(scanner, jdbcConnection);
        case 2 -> insertUserMethod(scanner, jdbcConnection);
        case 3 -> deleteUserOperation(scanner, jdbcConnection);
        case 4 -> {
          System.out.println("Hope it is an clear example to implement Singleton Design Pattern in Java !!!");
          scanner.close();
          return;
        }
        default -> System.out.print("Not a valid choice !!!");
      }
    }

  }

  private static Scanner getUserChoice() {
    System.out.println("***************");
    System.out.println("Select what you want to do in the database, insert a new user or select a user by username or delete a user by username !");
    System.out.println("1. Get a User by Username");
    System.out.println("2. Insert a New User");
    System.out.println("3. Delete a User by Username");
    System.out.println("4. Exit");
    return new Scanner(System.in);
  }

  /**
   * Get User Operation from DB by username
   * @param scanner Scanner input from command prompt
   * @param jdbcConnection singleton created JDBC connection. Please check {@link JdbcConnection} for more details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private static void getUserOperation(Scanner scanner, JdbcConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to search: ");
    String username = scanner.next();
    User user = jdbcConnection.getUser(username);
    if (Objects.nonNull(user))
      System.out.println(String.format("The username is %s and the password is %s !!!", user.getUsername(), user.getPassword()));
    else
      System.out.println(String.format("There is no user with username, %s !!!", username));
  }

  /**
   * Insert User Operation to DB
   * @param scanner Scanner input from command prompt
   * @param jdbcConnection singleton created JDBC connection. Please check {@link JdbcConnection} for more details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private static void insertUserMethod(Scanner scanner, JdbcConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to create: ");
    String username = scanner.next();
    System.out.print("Enter the password for the username: ");
    String password = scanner.next();
    jdbcConnection.insertUser(new User(username, password));
  }

  /**
   * Delete User Operation from DB by username
   * @param scanner Scanner input from command prompt
   * @param jdbcConnection singleton created JDBC connection. Please check {@link JdbcConnection} for more details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private static void deleteUserOperation(Scanner scanner, JdbcConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to delete: ");
    String username = scanner.next();
    jdbcConnection.deleteUser(username);
  }
}
