import java.util.Scanner;

public class JavaCamelCaseToSnakeCaseExample {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter a string in camelCase format: ");
    String myString = scanner.nextLine();
    scanner.close();

    JavaCamelCaseToSnakeCaseExample javaCamelCaseToSnakeCaseExample = new JavaCamelCaseToSnakeCaseExample();

    System.out.println(javaCamelCaseToSnakeCaseExample.camelToUnderscore(myString));

  }

  public String camelToUnderscore(String input) {
    if (input.isBlank())
      return "";

    String regex = "([a-z])([A-Z])";
    String replacement = "$1_$2";
    String result = input.replaceAll(regex, replacement).toLowerCase();
    if (result.startsWith("_"))
      return result.substring(1);
    return result;
  }
}