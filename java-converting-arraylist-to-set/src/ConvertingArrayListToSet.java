import java.util.*;
import java.util.stream.Collectors;

public class ConvertingArrayListToSet {

  public static void main(String[] args) {

    ConvertingArrayListToSet convertingArrayListToSet = new ConvertingArrayListToSet();

    //Initialise ArrayList
    List<String> myArrayList = Arrays.asList("Java", "Go", "C#", "PHP", "Java");
    convertingArrayListToSet.printInfo(myArrayList, "Initialise ArrayList");

    //Converting ArrayList to Set by Naive Approach
    Set<String> mySetByNaiveApproach = new HashSet<>();
    Iterator<String> iterator = myArrayList.iterator();
    while(iterator.hasNext())
      mySetByNaiveApproach.add(iterator.next());
    convertingArrayListToSet.printInfo(mySetByNaiveApproach, "Converting ArrayList to Set by Naive Approach");

    //Converting ArrayList to Set by using Constructor
    Set<String> mySetByConstructor = new HashSet<>(myArrayList);
    convertingArrayListToSet.printInfo(mySetByConstructor, "Converting ArrayList to Set by using Constructor");

    //Converting ArrayList to Set by Stream API
    Set<String> mySetByStreamApi = myArrayList.stream().collect(Collectors.toSet());
    convertingArrayListToSet.printInfo(mySetByStreamApi, "Converting ArrayList to Set by Stream API");

    //Converting ArrayList to Set by Set Cop Method
    Set<String> mySetByCopy = Set.copyOf(myArrayList);
    convertingArrayListToSet.printInfo(mySetByCopy, "Converting ArrayList to Set by Set Cop Method");

  }

  /**
   * Method in order to print info about ArrayList and step name used in the example
   * @param myListObject Input Collection to be print the info
   * @param stepName Step Name
   * @param <T> Generic Type
   */
  protected <T> void printInfo(Collection<T> myListObject, String stepName) {
    System.out.println("************************");
    System.out.println("************************");
    System.out.println(stepName);
    System.out.println(String.format("Size of %s is %d", myListObject.getClass().getSimpleName(), myListObject.size()));
    System.out.println(String.format("Elements of %s are;", myListObject.getClass().getSimpleName()));
    System.out.println(myListObject);
  }
}
