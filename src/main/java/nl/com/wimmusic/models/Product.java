package nl.com.wimmusic.models;

import java.io.Serializable;

public class Product implements Serializable {
  private static final long serialVersionUID = -8584661383888853176L;

  public Product(
      int stock,
      String name,
      String description,
      double price,
      ProductType type
      ) {
    this.stock = stock;
    this.name = name;
    this.description = description;
    this.price = price;
    this.type = type;
  }
  private int id;
  private int stock;
  private String name;
  private String description;
  private double price;
  private ProductType type;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductType getType() {
    return type;
  }

  public void setType(ProductType type) {
    this.type = type;
  }


}
