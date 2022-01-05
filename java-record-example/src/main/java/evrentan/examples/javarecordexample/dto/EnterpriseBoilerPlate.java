package evrentan.examples.javarecordexample.dto;

import java.io.Serializable;
import java.util.Objects;

public class EnterpriseBoilerPlate implements Serializable {
  private String id;
  private String name;
  private String address;

  public EnterpriseBoilerPlate(String id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public String getId() {return id;}

  public void setId(String id) {this.id = id;}

  public String getName() {return name;}

  public void setName(String name) {this.name = name;}

  public String getAddress() {return address;}

  public void setAddress(String address) {this.address = address;}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EnterpriseBoilerPlate that = (EnterpriseBoilerPlate) o;
    return id.equals(that.id) && name.equals(that.name) && address.equals(that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address);
  }

  @Override
  public String toString() {
    return "EnterpriseBoilerPlate{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
