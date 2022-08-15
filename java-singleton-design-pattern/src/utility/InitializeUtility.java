package utility;

import dto.BaseClass;
import example.utility.SingletonDesignPatternExampleUtility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
}
