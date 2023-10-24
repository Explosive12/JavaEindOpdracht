package nl.com.wimmusic.models;

public class OrderItem {
  private int quantity;
  private Product product;

  public OrderItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
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
