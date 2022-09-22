public non-sealed class Instructor extends Person implements License {

  private String rank;

  public Instructor(String name, String email, String rank) {
    super(name, email);
    this.rank = rank;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  @Override
  public boolean checkValidForFreeLicense() {
    if (this.getRank().equalsIgnoreCase("assistantProfessor") || this.getRank().equalsIgnoreCase("associateProfessor"))
      return Boolean.TRUE;

    return Boolean.FALSE;
  }
}
