import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultiplePredicatesToStreamFilter {

  private static final List<Integer> myIntegerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

  public static void main(String[] args) {

    Predicate<Integer> isEven = i -> i % 2 == 0;
    Predicate<Integer> isGreaterThan5 = i -> i > 5;
    List<Predicate<Integer>> myPredicateList = Arrays.asList(isEven, isGreaterThan5);
    // reduce Predicate list to a single Predicate
    Predicate<Integer> myPredicatesWithOr = myPredicateList.stream().reduce(Predicate::or).orElse(p -> false);
    Predicate<Integer> myPredicatesWithAnd = myPredicateList.stream().reduce(Predicate::and).orElse(p -> true);

    final String myEvenIntegersOrGreaterThan5WithReducedPredicates = myIntegerList.stream()
        .filter(myPredicatesWithOr)
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    final String myEvenIntegersOrGreaterThan5WithPredicateOperators = myIntegerList.stream()
        .filter(isEven.or(isGreaterThan5))
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    final String myEvenIntegersAndGreaterThan5WithReducedPredicates = myIntegerList.stream()
        .filter(myPredicatesWithAnd)
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    final String myEvenIntegersAndGreaterThan5WithPredicateOperators = myIntegerList.stream()
        .filter(isEven.and(isGreaterThan5))
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    final String myOddIntegersAndSmallerThanOrEqualTo5WithPredicateOperators = myIntegerList.stream()
        .filter(isEven.negate().and(isGreaterThan5.negate()))
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    System.out.println(String.format("Even Integers or Integers Greater than 5 are with reduced predicates; %s", myEvenIntegersOrGreaterThan5WithReducedPredicates));
    //  Even Integers or Integers Greater Than 5 are; 2, 4, 6, 7, 8, 9, 10
    System.out.println(String.format("Even Integers or Integers Greater than 5 are with predicate operators; %s", myEvenIntegersOrGreaterThan5WithPredicateOperators));
    //  Even Integers or Integers Greater than 5 are with predicate operators; 2, 4, 6, 7, 8, 9, 10
    System.out.println(String.format("Even Integers and Integers Greater than 5 are with reduced predicates; %s", myEvenIntegersAndGreaterThan5WithReducedPredicates));
    // Even Integers and Integers Greater Than 5 are; 6, 8, 10
    System.out.println(String.format("Even Integers and Integers Greater than 5 are with predicate operators; %s", myEvenIntegersAndGreaterThan5WithPredicateOperators));
    // Even Integers and Integers Greater than 5 are with predicate operators; 6, 8, 10
    System.out.println(String.format("Odd Integers and Integers Smaller than or Equal to 5 are with predicate operators; %s", myOddIntegersAndSmallerThanOrEqualTo5WithPredicateOperators));
    // Odd Integers and Integers Smaller than or Equal to 5 are with predicate operators; 1, 3, 5
  }
}
