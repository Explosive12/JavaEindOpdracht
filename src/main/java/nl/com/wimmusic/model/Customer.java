package nl.com.wimmusic.model;

import java.io.Serializable;

public class Customer implements Serializable {

  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phoneNumber;

  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
}
