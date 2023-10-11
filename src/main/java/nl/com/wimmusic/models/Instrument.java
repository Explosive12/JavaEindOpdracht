package nl.com.wimmusic.models;

public class Instrument {



  private int id;
  private int quantity;
  private String name;
  private InstrumentType type;
  private Boolean isBorrowed;

  public Instrument(int id, int quantity, String name, InstrumentType type, Boolean isBorrowed) {
    this.id = id;
    this.quantity = quantity;
    this.name = name;
    this.type = type;
    this.isBorrowed = isBorrowed;
  }
}
