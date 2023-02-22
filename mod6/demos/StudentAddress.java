public class StudentAddress implements java.io.Serializable {
  public String name, street, city, state, zip;

  public StudentAddress(String name, String street, String city,
    String state, String zip) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }
}