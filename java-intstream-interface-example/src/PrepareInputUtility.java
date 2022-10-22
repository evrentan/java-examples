import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrepareInputUtility {

  protected static int prepareStartInteger(Scanner scanner) {
    System.out.print("Enter the start integer (inclusive) to find the number of twos in the stream (must be equal or greater than 0): ");
    final int startInteger = scanner.nextInt();
    if (startInteger < 0) throw new IllegalArgumentException("Start integer should be equal or greater than 0");

    return startInteger;
  }

  protected static int prepareEndInteger(Scanner scanner, int startInteger) {
    System.out.print("Enter the end integer (inclusive) (must be equal or greater than 0): ");
    final int endInteger = scanner.nextInt();
    if (endInteger < 0 || endInteger < startInteger) throw new IllegalArgumentException("End integer should be equal or greater than 0 and greater than start integer");

    return endInteger;
  }

  protected static int prepareIntegerToBeChecked(Scanner scanner) {
    System.out.print("Enter the integer that you want to find the occurrence number in the requested interval (integer should be between 0 - 9): ");
    final int integerToBeChecked = scanner.nextInt();
    if (integerToBeChecked < 0 || integerToBeChecked > 9) throw new IllegalArgumentException("Integer should be between 0 to 9");

    return integerToBeChecked;
  }

  protected static List<Integer> prepareIntegerList(int startInteger, int endInteger) {
    return IntStream.rangeClosed(startInteger, endInteger).boxed().toList();
  }
}
