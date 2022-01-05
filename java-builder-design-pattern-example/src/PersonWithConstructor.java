import java.util.Objects;

public class PersonWithConstructor {
  private String firstName;
  private String lastName;
  private Integer age;
  private String sex;

  public PersonWithConstructor(String firstName, String lastName, Integer age, String sex) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.sex = sex;
  }

  public PersonWithConstructor(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "PersonWithConstructor{" +
        (Objects.nonNull(firstName) ? "firstName='" + firstName + '\'' : "") +
        (Objects.nonNull(lastName) ? ", lastName='" + lastName + '\'' : "") +
        (Objects.nonNull(age) ? ", age=" + age : "") +
        (Objects.nonNull(sex) ? ", sex='" + sex + '\'' : "") +
        '}';
  }
}
