import java.util.ArrayList;
import java.util.List;

public class JavaPatternMatchingForSwitchExample {

  public static void main(String[] args) {
    List<Object> myObjectList = new ArrayList<>();

    InitializeUtility.initializeInputs(myObjectList);

    TypePatternWithInstanceOfUtility.checkObjectListTypePatternWithInstanceOf(myObjectList);
    TypePatternWithSwitchUtility.checkObjectListTypePatternWithSwitch(myObjectList);
  }
}
