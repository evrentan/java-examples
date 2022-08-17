import utility.InitializeUtility;

import java.sql.SQLException;

public class JavaSingletonDesignPattern {

  public static void main(String[] args) throws SQLException {
    int choice = InitializeUtility.initialize();
    if (choice == 1)
      InitializeUtility.runSingletonDesignPatternExample();
    else {
      InitializeUtility.runJdbcConnectionExample();
    }
  }
}
