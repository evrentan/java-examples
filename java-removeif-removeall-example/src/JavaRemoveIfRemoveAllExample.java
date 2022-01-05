import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaRemoveIfRemoveAllExample {

  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(StudentBuilder.initialize().withName("Evren").withGpa(4.00).build());
    studentList.add(StudentBuilder.initialize().withName("Test").withGpa(2.00).build());
    studentList.add(StudentBuilder.initialize().withName("Student").withGpa(3.00).build());
    studentList.add(StudentBuilder.initialize().withName("Hebele").withGpa(2.50).build());
    studentList.add(StudentBuilder.initialize().withName("Hubele").withGpa(1.00).build());

    studentList.removeIf(student -> student.getGpa() < 2.20);
    System.out.println("Available student names for graduation are;");
    List<String> availableStudentNamesForGraduation = studentList.stream().map(Student::getName).peek(System.out::println).collect(Collectors.toList());

    List<String> studentNameListToBeRemoved = Arrays.asList("Hebele", "Student", "Hubele");
    availableStudentNamesForGraduation.removeAll(studentNameListToBeRemoved);
    System.out.println("\nThe most successful students are;");
    availableStudentNamesForGraduation.stream().peek(System.out::println).collect(Collectors.toList());
  }
}
