package nl.com.wimmusic.models;
import java.io.Serializable;

public class Instrument implements Serializable {

  private int id;
  private int quantity;
  private String name;
  private InstrumentType type;
  private Boolean isBorrowed;

  public Instrument () {
    this.id = 0;
    this.quantity = 0;
    this.name = "";
    this.type = InstrumentType.None;
    this.isBorrowed = false;
  }

  public Instrument(int id, int quantity, String name, InstrumentType type, Boolean isBorrowed) {
    this.id = id;
    this.quantity = quantity;
    this.name = name;
    this.type = type;
    this.isBorrowed = isBorrowed;
  }
}
