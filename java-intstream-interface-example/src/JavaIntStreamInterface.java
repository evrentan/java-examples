import java.util.List;
import java.util.Scanner;

public class JavaIntStreamInterface {
  public static void main(String[] args) {

    JavaIntStreamInterface javaIntStreamInterface = new JavaIntStreamInterface();

    Scanner scanner = new Scanner(System.in);

    int startInteger = PrepareInputUtility.prepareStartInteger(scanner);
    int endInteger = PrepareInputUtility.prepareEndInteger(scanner, startInteger);
    int integerToBeChecked = PrepareInputUtility.prepareIntegerToBeChecked(scanner);

    scanner.close();

    final List<Integer> integerList = PrepareInputUtility.prepareIntegerList(startInteger, endInteger);

    final long occurrenceNumber = javaIntStreamInterface.getOccurrenceNumber(integerToBeChecked, integerList);

    System.out.println(String.format("%d is occured %d times in the given interval", integerToBeChecked, occurrenceNumber));
  }

  private long getOccurrenceNumber(int integerToBeChecked, List<Integer> integerList) {
    return integerList.stream()
        .map(Object::toString)
          .map(String::chars)
            .toList()
              .stream()
                .map(i -> i.mapToObj(j -> (char) j))
                  .toList()
                    .stream()
                      .flatMap(c -> c)
                        .filter(c -> c == Character.forDigit(integerToBeChecked, 10))
                          .count();
  }
}