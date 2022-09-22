public non-sealed class Student extends Person implements License {

  private String classYear;

  public Student(String name, String email, String classYear) {
    super(name, email);
    this.classYear = classYear;
  }

  public String getClassYear() {
    return classYear;
  }

  public void setClassYear(String classYear) {
    this.classYear = classYear;
  }

  @Override
  public boolean checkValidForFreeLicense() {
    if (this.getClassYear().equalsIgnoreCase("freshman") || this.getClassYear().equalsIgnoreCase("sophomore"))
      return Boolean.TRUE;

    return Boolean.FALSE;
  }
}
