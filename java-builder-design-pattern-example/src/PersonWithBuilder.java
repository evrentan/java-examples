import java.util.Objects;

public class PersonWithBuilder {
  private String firstName;
  private String lastName;
  private Integer age;
  private String sex;

  private PersonWithBuilder(PersonBuilder personBuilder) {
    this.firstName = personBuilder.firstName;
    this.lastName = personBuilder.lastName;
    this.age = personBuilder.age;
    this.sex = personBuilder.sex;
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

  public static class PersonBuilder {
    private String firstName;
    private String lastName;
    private Integer age;
    private String sex;

    public static PersonBuilder initialize() {
      return new PersonBuilder();
    }

    public PersonBuilder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public PersonBuilder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public PersonBuilder withAge(Integer age) {
      this.age = age;
      return this;
    }

    public PersonBuilder withSex(String sex) {
      this.sex = sex;
      return this;
    }

    public PersonWithBuilder build() {
      return new PersonWithBuilder(this);
    }
  }
}
