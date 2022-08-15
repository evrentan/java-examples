import java.util.List;

public class TypePatternWithSwitchUtility {

  private TypePatternWithSwitchUtility() {
    throw new IllegalStateException("Utility Class !!!");
  }

  /**
   * Check Object List Type Pattern with Switch
   * Call {@link #checkObjectTypePatternWithSwitch(Object) checkObjectTypePatternWithSwitch} method to check objects one by one using switch
   *
   * @param objectList List of objects that is going to be checked for type pattern
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  protected static void checkObjectListTypePatternWithSwitch(List<Object> objectList) {
    System.out.println("*********************");
    System.out.println("Checking Object List Type Pattern with Switch");
    objectList.forEach(TypePatternWithSwitchUtility::checkObjectTypePatternWithSwitch);
    System.out.println("*********************");
  }

  /**
   * Check Object Type Pattern with switch
   *
   * @param o Object that is going to be checked for type pattern
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private static void checkObjectTypePatternWithSwitch(Object o) {
    switch (o) {
      case String s -> System.out.println(String.format("%s is a String with length %d !!!", s, s.length()));
      case Integer i -> System.out.println(String.format("%d is an Integer !!!", i));
      default -> System.out.println("Object is not Pre-Defined !!!");
    }
  }
}
