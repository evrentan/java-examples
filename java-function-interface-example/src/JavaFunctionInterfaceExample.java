import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class JavaFunctionInterfaceExample {

  public static void main(String[] args) {
    UnaryOperator<String> concatLove = s -> s.concat(" is love");
    Function<String, Integer> findStringLength = String::length;
    UnaryOperator<Integer> findSquare = i -> i * i;

    List<String> myLanguageList = Arrays.asList("Java", "Go", "PHP", "C#");

    myLanguageList.stream().map(s -> findStringLength.compose(concatLove).andThen(findSquare).apply(s)).forEach(System.out::println);

  }
}
