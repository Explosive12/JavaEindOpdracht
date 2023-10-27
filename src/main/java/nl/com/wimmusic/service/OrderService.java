package nl.com.wimmusic.service;

import java.util.List;
import nl.com.wimmusic.model.Order;
import nl.com.wimmusic.model.OrderItem;
import nl.com.wimmusic.model.Product;

public class OrderService {
  private final Order order;

  public OrderService(Order order) {
    this.order = order;
  }

  public void addProductToOrder(Product product, int quantity) {
    List<OrderItem> orderItems = order.getOrderItems();
    for (OrderItem orderItem : orderItems) {
      if (orderItem.getProduct().equals(product)) {
        orderItem.setQuantity(orderItem.getQuantity() + quantity);
        return;
      }
    }
    orderItems.add(new OrderItem(product, quantity));
  }

  public void removeProductFromOrder(List<OrderItem> orderItems, OrderItem item) {
    orderItems.removeIf(orderItem -> orderItem.getProduct().equals(item.getProduct()));
  }
}
