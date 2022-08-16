package jdbc.dto;

import dto.BaseClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;

public class JdbcConnection extends BaseClass {
  private static JdbcConnection jdbcConnection;

  private JdbcConnection(){}

  public static JdbcConnection getInstance() {
    if (Objects.isNull(jdbcConnection))
      jdbcConnection = new JdbcConnection();

    return jdbcConnection;
  }

  private static Connection getConnection() {
    try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/singletonDesignPatternExample", "admin", "admin")) {
      return connection;
    } catch (SQLException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }

    return null;
  }

  public User getUser(String userName) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    User user = null;

    try {
      connection = getConnection();
      assert connection != null;
      preparedStatement = connection.prepareStatement("select * from user where userName=?");
      preparedStatement.setString(1, userName);
      user = (User) preparedStatement.executeQuery();
    } catch (SQLException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    } finally {
      if (Objects.nonNull(preparedStatement))
        preparedStatement.close();
      if (Objects.nonNull(connection))
        connection.close();
    }

    return user;
  }

  public Boolean insertUser(User user) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {

      if (Objects.isNull(getUser(user.getUserName()))) {
        connection = getConnection();
        assert connection != null;
        preparedStatement = connection.prepareStatement("insert into user(userName, password) values (?, ?)");
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement.execute();
      }

      System.out.println(String.format("%s userName already exists !!!", user.getUserName()));
      return false;
    } catch (SQLException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
      return false;
    } finally {
      if (Objects.nonNull(preparedStatement))
        preparedStatement.close();
      if (Objects.nonNull(connection))
        connection.close();
    }
  }
}
