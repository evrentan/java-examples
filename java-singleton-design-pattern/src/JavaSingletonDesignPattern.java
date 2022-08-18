import utility.InitializeUtility;

import java.sql.SQLException;

public class JavaSingletonDesignPattern {

  public static void main(String[] args) throws SQLException {
    int choice = InitializeUtility.initialize();
    switch (choice) {
      case 1 -> InitializeUtility.runSingletonDesignPatternExample();
      case 2 -> InitializeUtility.runJdbcConnectionExample();
      default -> System.out.println("Not a valid option !!!");
    }
  }
}
