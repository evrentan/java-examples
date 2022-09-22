import java.util.Arrays;
import java.util.List;

public class JavaSealedClassesExample {
  public static void main(String[] args) {

    JavaSealedClassesExample javaSealedClassesExample = new JavaSealedClassesExample();

    List<Person> personList = Arrays.asList(
        new Student("Jack", "jack@university.com", "freshman"),
        new Student("Julie", "julie@university.com", "senior"),
        new Instructor("Amelie", "amelie@university.com", "associateProfessor"),
        new Instructor("Evren", "evren@university.com", "professor")
    );

    personList.forEach(javaSealedClassesExample::printAvailabilityForFreeLicense);

  }

  private void printAvailabilityForFreeLicense(Person person) {
    String availability = "not available";
    if (person instanceof Student student) {
      if (((Student) person).checkValidForFreeLicense())
        availability = "available";
      System.out.println(String.format("%s is %s for free license because he/she is a/an %s", person.getName(), availability, student.getClassYear()));
    }
    if (person instanceof Instructor instructor) {
      if (((Instructor) person).checkValidForFreeLicense())
        availability = "available";
      System.out.println(String.format("%s is %s for free license because he/she is a/an %s", person.getName(), availability, instructor.getRank()));
    }
  }
}