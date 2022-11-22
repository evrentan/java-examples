import java.util.Arrays;
import java.util.Vector;
import java.util.stream.Collectors;

public class JavaVectorExample {
  public static void main(String[] args) {
    Vector<String> myVector = new Vector<>();

    myVector.add("Evren Tan");
    myVector.add("Software Crafter");
    myVector.addElement("Software Developer");

    System.out.println(String.format("My vector capacity is %d", myVector.capacity()));
    System.out.println(String.format("The first element of my vector is %s & the last element of my vector is %s", myVector.firstElement(), myVector.lastElement()));
    System.out.println(String.format("Is Evren a Software Crafter? %b", myVector.contains("Software Crafter")));

    myVector.remove("Software Developer");

    System.out.println(String.format("My vector size is %d", myVector.size()));

    myVector.add(1, "Co-founder of Turkey Java Community");

    System.out.println(Arrays.stream(myVector.toArray()).map(Object::toString).collect(Collectors.joining(", ")));
  }
}