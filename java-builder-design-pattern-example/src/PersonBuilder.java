public class PersonBuilder {

  Person person = new Person();

  public static PersonBuilder initialize() {return new PersonBuilder();}

  public PersonBuilder withFirstName(String firstName) {
    person.setFirstName(firstName);
    return this;
  }

  public PersonBuilder withLastName(String lastName) {
    person.setLastName(lastName);
    return this;
  }

  public PersonBuilder withFullName(String firstName, String lastName) {
    person.setFirstName(firstName);
    person.setLastName(lastName);
    return this;
  }

  public PersonBuilder withAge(Integer age) {
    person.setAge(age);
    return this;
  }

  public PersonBuilder withSex(String sex) {
    person.setSex(sex);
    return this;
  }

  public Person build() {return person;}
}
