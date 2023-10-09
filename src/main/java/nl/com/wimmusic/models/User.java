package nl.com.wimmusic.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class User extends Person implements Serializable {
  private final String userName;
  private final String password;

  public User(
      int id,
      Map<Integer, Instrument> instruments,
      String name,
      LocalDate birthDate,
      String userName,
      String password) {
    super(id, instruments, name, birthDate);
    this.userName = userName;
    this.password = password;
  }
}
