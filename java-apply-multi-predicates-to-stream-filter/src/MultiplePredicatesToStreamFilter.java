import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultiplePredicatesToStreamFilter {

  public static void main(String[] args) {
    List<Integer> myIntegerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Predicate<Integer> isEven = i -> i % 2 == 0;
    Predicate<Integer> isGreaterThan5 = i -> i > 5;
    List<Predicate<Integer>> myPredicateList = Arrays.asList(isEven, isGreaterThan5);
    // reduce Predicate list to a single Predicate
    Predicate<Integer> myPredicatesWithOr = myPredicateList.stream().reduce(Predicate::or).orElse(p -> false);
    Predicate<Integer> myPredicatesWithAnd = myPredicateList.stream().reduce(Predicate::and).orElse(p -> true);

    final String myEvenIntegersOrGreaterThan5 = myIntegerList.stream().
        filter(myPredicatesWithOr).
        map(Object::toString).
        collect(Collectors.joining(", "));

    final String myEvenIntegersAndGreaterThan5 = myIntegerList.stream().
        filter(myPredicatesWithAnd).
        map(Object::toString).
        collect(Collectors.joining(", "));

    System.out.println(String.format("Even Integers or Integers Greater than 5 are; %s", myEvenIntegersOrGreaterThan5));
    //  Even Integers or Integers Greater Than 5 are; 2, 4, 6, 7, 8, 9, 10
    System.out.println(String.format("Even Integers and Integers Greater than 5 are; %s", myEvenIntegersAndGreaterThan5));
    // Even Integers and Integers Greater Than 5 are; 6, 8, 10
  }
}
