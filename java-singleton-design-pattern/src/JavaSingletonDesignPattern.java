import utility.InitializeUtility;

public class JavaSingletonDesignPattern {

  public static void main(String[] args) {
    int choice = InitializeUtility.initialize();
    if (choice == 1)
      InitializeUtility.runSingletonDesignPatternExample();
  }
}
