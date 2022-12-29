import java.util.stream.Collectors;

public class CloneUtilityClass {
  protected static void cloneWithCloneableCloneMethod() throws CloneNotSupportedException {
    System.out.println("********** Clone Using Cloneable clone() Method ***********");

    PersonWithDirectlyUsingObjectClone personWithDirectlyUsingObjectClone = new PersonWithDirectlyUsingObjectClone("Evren Tan", 38);
    personWithDirectlyUsingObjectClone.addRandomRelatives();

    PersonWithDirectlyUsingObjectClone clonedPersonWithDirectlyUsingObjectClone = (PersonWithDirectlyUsingObjectClone) personWithDirectlyUsingObjectClone.clone();

    System.out.println(String.format("Check initial & cloned objects are equal? %b", personWithDirectlyUsingObjectClone.equals(clonedPersonWithDirectlyUsingObjectClone)));
    System.out.println(String.format("Check relatives between initial & cloned object? %b", personWithDirectlyUsingObjectClone.getRelatives().equals(clonedPersonWithDirectlyUsingObjectClone.getRelatives())));

    // add a relative to the cloned object
    clonedPersonWithDirectlyUsingObjectClone.getRelatives().add(new PersonWithDirectlyUsingObjectClone("Dino Baggio", 51));
    System.out.println(String.format("Inital Object Relatives are; %s",personWithDirectlyUsingObjectClone.getRelatives().stream().map(PersonWithDirectlyUsingObjectClone::getName).collect(Collectors.joining(", "))));
  }

  protected static void cloneWithSwallowClone() throws CloneNotSupportedException {
    System.out.println("********** Swallow Clone ***********");

    PersonWithSwallowClone personWithSwallowClone = new PersonWithSwallowClone("Evren Tan", 38);
    personWithSwallowClone.addRandomRelatives();

    PersonWithSwallowClone clonedPersonWithSwallowClone = (PersonWithSwallowClone) personWithSwallowClone.clone();

    System.out.println(String.format("Check initial & cloned objects are equal? %b", personWithSwallowClone.equals(clonedPersonWithSwallowClone)));
    System.out.println(String.format("Check relatives between initial & cloned object? %b", personWithSwallowClone.getRelatives().equals(clonedPersonWithSwallowClone.getRelatives())));

    // add a relative to the cloned object
    clonedPersonWithSwallowClone.getRelatives().add(new PersonWithSwallowClone("Dino Baggio", 51));
    System.out.println(String.format("Inital Object Relatives are; %s",personWithSwallowClone.getRelatives().stream().map(PersonWithSwallowClone::getName).collect(Collectors.joining(", "))));
  }

  protected static void cloneWithDeepClone() throws CloneNotSupportedException {
    System.out.println("********** Deep Clone ***********");

    PersonWithDeepClone personWithDeepClone = new PersonWithDeepClone("Evren Tan", 38);
    personWithDeepClone.addRandomRelatives();

    PersonWithDeepClone clonedPersonWithDeepClone = (PersonWithDeepClone) personWithDeepClone.clone();

    System.out.println(String.format("Check initial & cloned objects are equal? %b", personWithDeepClone.equals(clonedPersonWithDeepClone)));
    System.out.println(String.format("Check relatives between initial & cloned object? %b", personWithDeepClone.getRelatives().equals(clonedPersonWithDeepClone.getRelatives())));

    // add a relative to the cloned object
    clonedPersonWithDeepClone.getRelatives().add(new PersonWithDeepClone("Dino Baggio", 51));
    System.out.println(String.format("Inital Object Relatives are; %s",personWithDeepClone.getRelatives().stream().map(PersonWithDeepClone::getName).collect(Collectors.joining(", "))));
  }
}
