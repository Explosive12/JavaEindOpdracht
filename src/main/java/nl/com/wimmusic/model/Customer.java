package nl.com.wimmusic.model;

public class Customer {

  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phoneNumber;
  private int id;

  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
}
