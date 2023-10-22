package nl.com.wimmusic.models;

import java.io.Serializable;

public class Instrument implements Serializable {
  private static final long serialVersionUID = -8584661383888853176L;

  public Instrument(
      int id,
      int stock,
      String name,
      String description,
      double price,
      InstrumentType type,
      Boolean isBorrowed) {
    this.id = id;
    this.stock = stock;
    this.name = name;
    this.description = description;
    this.price = price;
    this.type = type;
    this.isBorrowed = isBorrowed;
  }
  private int id;
  private int stock;
  private int quantity;
  private String name;
  private String description;
  private double price;
  private InstrumentType type;
  private Boolean isBorrowed;

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InstrumentType getType() {
    return type;
  }

  public void setType(InstrumentType type) {
    this.type = type;
  }

  public Boolean getBorrowed() {
    return isBorrowed;
  }

  public void setBorrowed(Boolean borrowed) {
    isBorrowed = borrowed;
  }
}
