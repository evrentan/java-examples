public class PrintHello {
  private String value;
  private String name;

  public PrintHello() {}

  public String getValue() {return value;}

  public void setValue(String value) {this.value = value;}

  public String getName() {return name;}

  public void setName(String name) {this.name = name;}

  private void printHello() {
    System.out.println(this.value);
  }
}
