package jdbc.dto;

import dto.BaseClass;

import java.sql.*;
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
      System.out.println("Successfully connected to the PostgreSQL server !!!");
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
    final String getUserByUserNameSqlStatement = "select * from public.apl_user where username = ?";

    try {
      connection = getConnection();
      assert connection != null;
      preparedStatement = connection.prepareStatement(getUserByUserNameSqlStatement);
      preparedStatement.setString(1, userName);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next())
        System.out.println(resultSet);
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

      if (Objects.isNull(getUser(user.getUsername()))) {
        connection = getConnection();
        assert connection != null;
        preparedStatement = connection.prepareStatement("insert into public.apl_user(username, password) values (?, ?)");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement.execute();
      }

      System.out.println(String.format("%s userName already exists !!!", user.getUsername()));
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
