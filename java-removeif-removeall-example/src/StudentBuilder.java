public class StudentBuilder {

  Student student = new Student();

  public static StudentBuilder initialize() {
    return new StudentBuilder();
  }

  public StudentBuilder withAllInfo(String name, Double gpa) {
    student.setName(name);
    student.setGpa(gpa);
    return this;
  }

  public StudentBuilder withName(String name) {
    student.setName(name);
    return this;
  }

  public StudentBuilder withGpa(Double gpa) {
    student.setGpa(gpa);
    return this;
  }

  public Student build() {
    return student;
  }
}
