package jdbc.utility;

import jdbc.dto.JDBCConnection;
import jdbc.dto.User;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class JDBCConnectionUtility {

  public void runJDBCConnection() throws SQLException {
    JDBCConnection jdbcConnection = JDBCConnection.getInstance();

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

  private Scanner getUserChoice() {
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
   * @param jdbcConnection singleton created JDBC connection. Please check {@link JDBCConnection} for more details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void getUserOperation(Scanner scanner, JDBCConnection jdbcConnection) throws SQLException {
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
   * @param jdbcConnection singleton created JDBC connection. Please check {@link JDBCConnection} for more details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void insertUserMethod(Scanner scanner, JDBCConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to create: ");
    String username = scanner.next();
    System.out.print("Enter the password for the username: ");
    String password = scanner.next();
    jdbcConnection.insertUser(new User(username, password));
  }

  /**
   * Delete User Operation from DB by username
   * @param scanner Scanner input from command prompt
   * @param jdbcConnection singleton created JDBC connection. Please check {@link JDBCConnection} for more details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void deleteUserOperation(Scanner scanner, JDBCConnection jdbcConnection) throws SQLException {
    System.out.print("Enter the username that you want to delete: ");
    String username = scanner.next();
    jdbcConnection.deleteUser(username);
  }
}
