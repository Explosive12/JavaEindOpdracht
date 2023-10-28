package nl.com.wimmusic.model;

import java.io.Serializable;

public class OrderItem implements Serializable {
  private int quantity;
  private Product product;

  public OrderItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public double getTotalPrice() {
    return product.getPrice() * quantity;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public ProductType getType() {
    return product.getType();
  }

  public String getName() {
    return product.getName();
  }

  public double getPrice() {
    return product.getPrice();
  }
}
