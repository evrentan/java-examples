import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaPatternMatchingForSwitchExample {

  public static void main(String[] args) {
    JavaPatternMatchingForSwitchExample javaPatternMatchingForSwitchExample = new JavaPatternMatchingForSwitchExample();

    List<Object> myObjectList = new ArrayList<>();

    javaPatternMatchingForSwitchExample.initializeInputs(myObjectList);

    javaPatternMatchingForSwitchExample.checkObjectListTypePatternWithInstanceOf(myObjectList);
    javaPatternMatchingForSwitchExample.checkObjectListTypePatternWithSwitch(myObjectList);

    System.out.println("*********************");
  }

  /**
   * Initialize inputs for the application
   *
   * @param myObjectList Empty object list to be filled from command prompt inputs
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void initializeInputs(List<Object> myObjectList) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("*********************");
    System.out.println("This is an example Java app of how pattern matching for switch works");
    System.out.print("Enter a String Value: ");
    myObjectList.add(scanner.nextLine());
    System.out.print("Enter an Integer Value: ");
    myObjectList.add(scanner.nextInt());
    scanner.close();
    System.out.println("*********************");
  }

  /**
   * Check Object List Type Pattern with instanceOf
   * Call {@link #checkObjectTypePatternWithInstanceOf(Object) checkObjectTypePatternWithInstanceOf} method to check objects one by one using instanceOf
   *
   * @param objectList List of objects that is going to be checked for type pattern
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void checkObjectListTypePatternWithInstanceOf (List<Object> objectList) {
    System.out.println("*********************");
    System.out.println("Checking Object List Type Pattern with instanceOf");
    objectList.forEach(this::checkObjectTypePatternWithInstanceOf);
    System.out.println("*********************");
  }

  /**
   * Check Object Type Pattern with instanceOf
   *
   * @param o Object that is going to be checked for type pattern
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void checkObjectTypePatternWithInstanceOf (Object o) {
    if (o instanceof String s)
      System.out.println(String.format("%s is a String with length %d !!!", s, s.length()));
    else if (o instanceof Integer i)
      System.out.println(String.format("%d is an Integer !!!", i));
    else
      System.out.println("Object is not Pre-Defined !!!");
  }

  /**
   * Check Object List Type Pattern with Switch
   * Call {@link #checkObjectTypePatternWithSwitch(Object) checkObjectTypePatternWithSwitch} method to check objects one by one using switch
   *
   * @param objectList List of objects that is going to be checked for type pattern
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void checkObjectListTypePatternWithSwitch (List<Object> objectList) {
    System.out.println("*********************");
    System.out.println("Checking Object List Type Pattern with Switchth");
    objectList.forEach(this::checkObjectTypePatternWithSwitch);
    System.out.println("*********************");
  }

  /**
   * Check Object Type Pattern with switch
   *
   * @param o Object that is going to be checked for type pattern
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private void checkObjectTypePatternWithSwitch (Object o) {
    switch (o) {
      case String s -> System.out.println(String.format("%s is a String with length %d !!!", s, s.length()));
      case Integer i -> System.out.println(String.format("%d is an Integer !!!", i));
      default -> System.out.println("Object is not Pre-Defined !!!");
    }
  }
}
