package jdbc.dto;

import dto.BaseClass;

import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;

public class JdbcConnection extends BaseClass {
  private static JdbcConnection jdbcConnection;
  private Connection connection;
  private Statement statement;
  private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/singletonDesignPatternExample";
  private static final String CONNECTION_USERNAME = "admin";
  private static final String CONNECTION_PASSWORD = "admin";

  private JdbcConnection() throws SQLException {
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

  public static JdbcConnection getInstance() {
    try {
      if (Objects.isNull(jdbcConnection))
        jdbcConnection = new JdbcConnection();
    } catch (SQLException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }
    return jdbcConnection;
  }

  public User getUser(String username) throws SQLException {
    final String getUserByUserNameSqlStatement = String.format("select * from public.apl_user where username = '%s'", username);

    ResultSet resultSet = statement.executeQuery(getUserByUserNameSqlStatement);
    if (resultSet.next()) {
        return new User(resultSet.getString("username"), resultSet.getString("password"));
    }

    return null;
  }

  public Boolean insertUser(User user) throws SQLException {
    final String insertUserSqlStatement = String.format("insert into public.apl_user(username, password) values ('%s', '%s')", user.getUsername(), user.getPassword());

    if (Objects.isNull(getUser(user.getUsername())))
      return statement.execute(insertUserSqlStatement);

      System.out.println(String.format("%s userName already exists !!!", user.getUsername()));
      return false;
    }
}
