import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PersonWithSwallowClone implements Cloneable {
  private String name;
  private Integer age;
  private List<PersonWithSwallowClone> relatives = new ArrayList<>();

  public PersonWithSwallowClone() {
  }

  public PersonWithSwallowClone(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonWithSwallowClone that = (PersonWithSwallowClone) o;
    return name.equals(that.name) && age.equals(that.age) && Objects.equals(relatives, that.relatives);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, relatives);
  }

  @Override
  public String toString() {
    return "PersonWithSwallowClone{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", relatives=" + relatives +
        '}';
  }

  public List<PersonWithSwallowClone> getRelatives() {
    return relatives;
  }

  public void setRelatives(List<PersonWithSwallowClone> relatives) {
    this.relatives = relatives;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {

    PersonWithSwallowClone personWithSwallowClone = new PersonWithSwallowClone();
    personWithSwallowClone.setName(this.name);
    personWithSwallowClone.setAge(this.age);
    personWithSwallowClone.setRelatives(this.relatives);

    return personWithSwallowClone;
  }

  public void addRandomRelatives() {
    this.relatives.addAll(Arrays.asList(
        new PersonWithSwallowClone("Roberto Baggio", 55),
        new PersonWithSwallowClone("Alessandro Del Piero", 48)));
  }
}
