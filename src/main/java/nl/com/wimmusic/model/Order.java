package nl.com.wimmusic.model;

import javafx.collections.ObservableList;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

  @Serial private static final long serialVersionUID = -4254297335272596267L;

  private List<OrderItem> orderItems;
  private Customer customer;
  private LocalDateTime orderDate;

  public Order(Customer customer) {
    this.orderItems = new ArrayList<>();
    this.customer = customer;
    this.orderDate = LocalDateTime.now();
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate() {
    this.orderDate = LocalDateTime.now();
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (OrderItem orderItem : orderItems) {
      totalPrice += orderItem.getTotalPrice();
    }
    return totalPrice;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public String getName() {
    return customer.getFirstName() + " " + customer.getLastName();
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
