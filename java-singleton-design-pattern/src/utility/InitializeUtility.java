package utility;

import dto.BaseClass;
import example.utility.SingletonDesignPatternExampleUtility;
import jdbc.utility.JDBCConnectionUtility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static void runJDBCConnectionExample() {
    try {
      Object jdbcConnection = JDBCConnectionUtility.class.getDeclaredConstructor().newInstance();
      Method method = jdbcConnection.getClass().getDeclaredMethod("runJDBCConnection");
      method.invoke(jdbcConnection);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException exception) {
      logger.log(Level.SEVERE, exception.getMessage());
    }
  }
}
