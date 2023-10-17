package nl.com.wimmusic.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class User implements Serializable {

  private final int id;
  private final Map<Integer, Instrument> instruments;
  private final String userName;
  private final String password;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  protected UserRoles userRole;

  public User(int id, Map<Integer, Instrument> instruments, String userName, String password, String firstName, String lastName, LocalDate birthDate) {
    this.id = id;
    this.instruments = instruments;
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.userRole = UserRoles.None;
  }


  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}
