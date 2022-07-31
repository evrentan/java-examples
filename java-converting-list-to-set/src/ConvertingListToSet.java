import java.util.*;
import java.util.stream.Collectors;

public class ConvertingListToSet {

  private static final String INITIALISE_LIST = "Initialise List";
  private static final String USING_NAIVE_APPROACH = "Converting List to Set by Naive Approach";
  private static final String USING_CONSTRUCTOR = "Converting List to Set by Using Constructor";
  private static final String USING_STREAM_API = "Converting List to Set by Using Stream API";
  private static final String USING_SET_COPY_METHOD = "Converting List to Set by Set Copy Method";

  public static void main(String[] args) {

    ConvertingListToSet convertingListToSet = new ConvertingListToSet();

    //Initialise List
    List<String> myList = Arrays.asList("Java", "Go", "C#", "PHP", "Java");
    convertingListToSet.printInfo(myList, INITIALISE_LIST);

    //Converting ArrayList to Set by Naive Approach
    Set<String> mySetByNaiveApproach = new HashSet<>();
    Iterator<String> iterator = myList.iterator();
    while(iterator.hasNext())
      mySetByNaiveApproach.add(iterator.next());
    convertingListToSet.printInfo(mySetByNaiveApproach, USING_NAIVE_APPROACH);

    //Converting List to Set by using Constructor
    Set<String> mySetByConstructor = new HashSet<>(myList);
    convertingListToSet.printInfo(mySetByConstructor, USING_CONSTRUCTOR);

    //Converting List to Set by Stream API
    Set<String> mySetByStreamApi = myList.stream().collect(Collectors.toSet());
    convertingListToSet.printInfo(mySetByStreamApi, USING_STREAM_API);

    //Converting List to Set by Set Copy Method
    Set<String> mySetByCopy = Set.copyOf(myList);
    convertingListToSet.printInfo(mySetByCopy, USING_SET_COPY_METHOD);

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
