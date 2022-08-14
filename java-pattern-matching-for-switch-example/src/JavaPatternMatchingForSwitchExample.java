import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaPatternMatchingForSwitchExample {

  public static void main(String[] args) {
    JavaPatternMatchingForSwitchExample javaPatternMatchingForSwitchExample = new JavaPatternMatchingForSwitchExample();

    List<Object> myObjectList = new ArrayList<>();

    javaPatternMatchingForSwitchExample.generateObjectList(myObjectList);

    javaPatternMatchingForSwitchExample.checkObjectListTypePatternWithInstanceOf(myObjectList);
    javaPatternMatchingForSwitchExample.checkObjectListTypePatternWithSwitch(myObjectList);

    System.out.println("*********************");
  }

  private void generateObjectList(List<Object> myObjectList) {
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

  private void checkObjectListTypePatternWithInstanceOf (List<Object> objectList) {
    System.out.println("*********************");
    System.out.println("Checking Object List Type Pattern with instanceOf");
    objectList.forEach(this::checkObjectTypePatternWithInstanceOf);
    System.out.println("*********************");
  }

  private void checkObjectTypePatternWithInstanceOf (Object o) {
    if (o instanceof String s)
      System.out.println(String.format("%s is a String with length %d !!!", s, s.length()));
    else if (o instanceof Integer i)
      System.out.println(String.format("%d is an Integer !!!", i));
    else
      System.out.println("Object is not Pre-Defined !!!");
  }

  private void checkObjectListTypePatternWithSwitch (List<Object> objectList) {
    System.out.println("*********************");
    System.out.println("Checking Object List Type Pattern with Switchth");
    objectList.forEach(this::checkObjectTypePatternWithSwitch);
    System.out.println("*********************");
  }

  private void checkObjectTypePatternWithSwitch (Object o) {
    switch (o) {
      case String s -> System.out.println(String.format("%s is a String with length %d !!!", s, s.length()));
      case Integer i -> System.out.println(String.format("%d is an Integer !!!", i));
      default -> System.out.println("Object is not Pre-Defined !!!");
    }
  }
}
