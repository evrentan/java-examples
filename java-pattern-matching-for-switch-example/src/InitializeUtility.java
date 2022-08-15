import java.util.List;
import java.util.Scanner;

public class InitializeUtility {

  /**
   * Initialize inputs for the application
   *
   * @param myObjectList Empty object list to be filled from command prompt inputs
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  protected static void initializeInputs(List<Object> myObjectList) {
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
}
