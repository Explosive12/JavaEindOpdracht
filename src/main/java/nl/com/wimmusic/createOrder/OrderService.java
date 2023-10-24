package nl.com.wimmusic.createOrder;

import nl.com.wimmusic.models.OrderItem;
import nl.com.wimmusic.models.Product;
import nl.com.wimmusic.models.Order;

import java.util.List;

public class OrderService {
    private Order order;

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
