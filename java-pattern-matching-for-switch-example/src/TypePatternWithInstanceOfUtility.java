import java.util.List;

public class TypePatternWithInstanceOfUtility {

  private TypePatternWithInstanceOfUtility() {
    throw new IllegalStateException("Utility Class !!!");
  }

  /**
   * Check Object List Type Pattern with instanceOf
   * Call {@link #checkObjectTypePatternWithInstanceOf(Object) checkObjectTypePatternWithInstanceOf} method to check objects one by one using instanceOf
   *
   * @param objectList List of objects that is going to be checked for type pattern
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  protected static void checkObjectListTypePatternWithInstanceOf(List<Object> objectList) {
    System.out.println("*********************");
    System.out.println("Checking Object List Type Pattern with instanceOf");
    objectList.forEach(TypePatternWithInstanceOfUtility::checkObjectTypePatternWithInstanceOf);
    System.out.println("*********************");
  }

  /**
   * Check Object Type Pattern with instanceOf
   *
   * @param o Object that is going to be checked for type pattern
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  private static void checkObjectTypePatternWithInstanceOf(Object o) {
    if (o instanceof String s)
      System.out.println(String.format("%s is a String with length %d !!!", s, s.length()));
    else if (o instanceof Integer i)
      System.out.println(String.format("%d is an Integer !!!", i));
    else
      System.out.println("Object is not Pre-Defined !!!");
  }
}
