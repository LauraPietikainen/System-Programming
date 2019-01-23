

public class Person {
  private String name;
  private String address;

  public void setName(String aName) {
    this.name = aName;
  }

  public void setAddress(String aAddress) {
    this.address = aAddress;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public void printPersonInfo() {
    System.out.println("Person: " + this.name + " address:" + this.address);
  }

}
