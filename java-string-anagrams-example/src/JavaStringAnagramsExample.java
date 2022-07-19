import java.util.Scanner;

public class JavaStringAnagramsExample {

  static boolean isAnagram(String a, String b) {
    // Complete the function
    if (a.length() != b.length())
      return false;

    char[] aChar = a.toLowerCase().toCharArray();
    char[] bChar = b.toLowerCase().toCharArray();

    for (int i = 0; i <a.length() && aChar[i] != '&'; i++) {
      char controllerChar = aChar[i];
      int controllerCharNumber = 1;
      for (int j = i+1; j <a.length() && aChar[j] != '&'; j++) {
        if (aChar[j] == controllerChar) {
          controllerCharNumber++;
          aChar[j] = '&';
        }
      }
      int bControllerCharNumber = 0;
      for (int z = 0; z < b.length(); z++) {
        if (bChar[z] == controllerChar) bControllerCharNumber++;
      }
      if (controllerCharNumber != bControllerCharNumber) return false;
    }

    return true;
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
  }
}
