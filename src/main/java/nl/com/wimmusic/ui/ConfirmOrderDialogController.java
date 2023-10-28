package nl.com.wimmusic.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.Order;
import nl.com.wimmusic.model.OrderItem;
import nl.com.wimmusic.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConfirmOrderDialogController extends BaseController {
  private final Order order;
  @FXML private Button noButton;
  @FXML private Label errorLabel;


  public ConfirmOrderDialogController(User user, Database database, Order order) {
    super(user, database);
    this.order = order;
  }

  @FXML
  void onYesButton() {
    List<OrderItem> orderItems = order.getOrderItems();

    for (OrderItem orderItem : orderItems) {
      try {
        int newStock = orderItem.getProduct().getStock() - orderItem.getQuantity();
        if (newStock < 0) {
          errorLabel.setText(errorLabel.getText() + "Not enough stock for " + orderItem.getProduct().getName() + "\n");
          errorLabel.setVisible(true);
          return;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      database.updateProductStock(orderItem.getProduct(), orderItem.getQuantity());
    }

    order.setOrderDate();


    database.addOrder(order);
    closeWindow();
  }

  private void closeWindow() {
    Stage stage = (Stage) noButton.getScene().getWindow();
    stage.close();
  }

  @FXML
  void onNoButton() {
    closeWindow();
  }
}
