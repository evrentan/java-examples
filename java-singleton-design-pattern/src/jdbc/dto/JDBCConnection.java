package jdbc.dto;

import dto.AbstractBaseClass;

import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;

public class JDBCConnection extends AbstractBaseClass {
  private static JDBCConnection jdbcConnection;
  private Connection connection;
  private Statement statement;
  private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/singletonDesignPatternExample";
  private static final String CONNECTION_USERNAME = "admin";
  private static final String CONNECTION_PASSWORD = "admin";

  /**
   * Constructor method in order to create db connection & statement
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private JDBCConnection() throws SQLException {
    try {
      connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
      statement = connection.createStatement();
    } catch (SQLException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    } finally {
      if (Objects.isNull(statement)) {
        assert connection != null;
        connection.close();
      }
    }
  }

  /**
   * Create the instance of {@link JDBCConnection} object if it is not created yet and guarantee that there is only one single instance is created for this class.
   * @return JDBCConnection created single instance
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static JDBCConnection getInstance() {
    try {
      if (Objects.isNull(jdbcConnection))
        jdbcConnection = new JDBCConnection();
    } catch (SQLException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }
    return jdbcConnection;
  }

  /**
   * Get User by username from the DB
   * @param username that is going to be checked
   * @return User Please {@link User} for details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public User getUser(String username) throws SQLException {
    final String getUserByUserNameSqlStatement = String.format("select * from public.apl_user where username = '%s'", username);

    ResultSet resultSet = statement.executeQuery(getUserByUserNameSqlStatement);
    if (resultSet.next()) {
      return new User(resultSet.getString("username"), resultSet.getString("password"));
    }

    return null;
  }

  /**
   * Insert User to the DB by checking whether the same username exists or not.
   * @param user object that is going to be inserted to DB. Please {@link User} for details
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public void insertUser(User user) throws SQLException {
    final String insertUserSqlStatement = String.format("insert into public.apl_user(username, password) values ('%s', '%s')", user.getUsername(), user.getPassword());

    if (Objects.isNull(getUser(user.getUsername()))) {
      statement.execute(insertUserSqlStatement);
      System.out.println("User is successfully inserted !!!");
    } else
      System.out.println(String.format("%s userName already exists !!!", user.getUsername()));
  }

  /**
   * Delete the user instance that as the username in the parameter by checking whether the username exists or not.
   * @param username that is going to be deleted
   * @throws SQLException exception can be thrown during DB transaction
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public void deleteUser(String username) throws SQLException {
    final String deleteUserByUsernameSqlStatement = String.format("delete from public.apl_user where username = '%s'", username);

    if (Objects.nonNull(getUser(username))) {
      statement.execute(deleteUserByUsernameSqlStatement);
      System.out.println("User is successfully deleted !!!");
    } else
      System.out.println(String.format("%s userName does not exists !!!", username));
  }
}
