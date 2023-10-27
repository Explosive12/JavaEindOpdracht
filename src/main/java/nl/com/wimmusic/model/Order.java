package nl.com.wimmusic.model;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
  private List<OrderItem> orderItems;
  private Customer customer;
  private LocalDateTime orderDate;

  public Order(Customer customer) {
    this.orderItems = new ArrayList<>();
    this.customer = customer;
    this.orderDate = null;
  }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate() {
        orderDate = LocalDateTime.now();
    }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (OrderItem orderItem : orderItems) {
      totalPrice += orderItem.getTotalPrice();
    }
    return totalPrice;
  }
  public ObservableList<OrderItem> getOrderItems() {
    return (ObservableList<OrderItem>) orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
