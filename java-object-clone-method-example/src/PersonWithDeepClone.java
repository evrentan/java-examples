import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PersonWithDeepClone implements Cloneable {
  private String name;
  private Integer age;
  private List<PersonWithDeepClone> relatives = new ArrayList<>();

  public PersonWithDeepClone() {
  }

  public PersonWithDeepClone(String name, Integer age) {
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
    PersonWithDeepClone that = (PersonWithDeepClone) o;
    return name.equals(that.name) && age.equals(that.age) && Objects.equals(relatives, that.relatives);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, relatives);
  }

  @Override
  public String toString() {
    return "PersonWithDeepClone{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", relatives=" + relatives +
        '}';
  }

  public List<PersonWithDeepClone> getRelatives() {
    return relatives;
  }

  public void setRelatives(List<PersonWithDeepClone> relatives) {
    this.relatives = relatives;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {

    Object object = super.clone();

    PersonWithDeepClone personWithSwallowClone = (PersonWithDeepClone) object;

    personWithSwallowClone.setRelatives(null);
    List<PersonWithDeepClone> tempList = new ArrayList<>();
    this.relatives.forEach(tempList::add);
    personWithSwallowClone.setRelatives(tempList);

    return personWithSwallowClone;
  }

  public void addRandomRelatives() {
    this.relatives.addAll(Arrays.asList(
        new PersonWithDeepClone("Roberto Baggio", 55),
        new PersonWithDeepClone("Alessandro Del Piero", 48)));
  }
}
