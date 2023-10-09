package nl.com.wimmusic.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class Person implements Serializable {

  private final int id;
  private final Map<Integer, Instrument> instruments;
  private String name;
  private LocalDate birthDate;

  public Person(int id, Map<Integer, Instrument> instruments, String name, LocalDate birthDate) {
    this.id = id;
    this.instruments = instruments;
    this.name = name;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
}
