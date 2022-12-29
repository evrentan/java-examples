import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PersonWithDirectlyUsingObjectClone implements Cloneable {
  private String name;
  private Integer age;
  private List<PersonWithDirectlyUsingObjectClone> relatives = new ArrayList<>();

  public PersonWithDirectlyUsingObjectClone() {
  }

  public PersonWithDirectlyUsingObjectClone(String name, Integer age) {
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

  public List<PersonWithDirectlyUsingObjectClone> getRelatives() {
    return relatives;
  }

  public void setRelatives(List<PersonWithDirectlyUsingObjectClone> relatives) {
    this.relatives = relatives;
  }

  @Override
  public String toString() {
    return "PersonWithDirectlyUsingObjectClone{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", relatives=" + relatives +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonWithDirectlyUsingObjectClone that = (PersonWithDirectlyUsingObjectClone) o;
    return name.equals(that.name) && age.equals(that.age) && Objects.equals(relatives, that.relatives);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, relatives);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public void addRandomRelatives() {
    this.relatives.addAll(Arrays.asList(
        new PersonWithDirectlyUsingObjectClone("Roberto Baggio", 55),
        new PersonWithDirectlyUsingObjectClone("Alessandro Del Piero", 48)));
  }
}
