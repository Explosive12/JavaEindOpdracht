package nl.com.wimmusic.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.Order;
import nl.com.wimmusic.model.OrderItem;
import nl.com.wimmusic.model.Product;
import nl.com.wimmusic.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderHistoryController extends BaseController implements Initializable {

  @FXML private TableView<Order> orderTableView;
  @FXML private TableView<OrderItem> productTableView;

  public OrderHistoryController(User user, Database database) {
    super(user, database);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    orderTableView.setItems(database.getOrders());

    orderTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldOrder, newOrder) -> {
      if (newOrder == null) {
        return;
      }
      productTableView.getItems().clear();
        productTableView.getItems().addAll(newOrder.getOrderItems());
    });
  }
}
