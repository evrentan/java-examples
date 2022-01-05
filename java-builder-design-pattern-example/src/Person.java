import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private Integer age;
  private String sex;

  public String getFirstName() {return firstName;}

  public void setFirstName(String firstName) {this.firstName = firstName;}

  public String getLastName() {return lastName;}

  public void setLastName(String lastName) {this.lastName = lastName;}

  public Integer getAge() {return age;}

  public void setAge(Integer age) {this.age = age;}

  public String getSex() {return sex;}

  public void setSex(String sex) {this.sex = sex;}

  @Override
  public String toString() {
    return "Person{" +
        (Objects.nonNull(firstName) ? "firstName='" + firstName + '\'' : "") +
        (Objects.nonNull(lastName) ? ", lastName='" + lastName + '\'' : "") +
        (Objects.nonNull(age) ? ", age=" + age : "") +
        (Objects.nonNull(sex) ? ", sex='" + sex + '\'' : "") +
        '}';
  }
}
