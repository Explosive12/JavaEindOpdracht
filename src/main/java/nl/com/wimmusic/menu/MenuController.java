package nl.com.wimmusic.menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;
import nl.com.wimmusic.orderHistory.OrderHistoryController;
import nl.com.wimmusic.productInventory.ProductInventoryController;
import nl.com.wimmusic.ui.BaseController;
import nl.com.wimmusic.createOrder.OrderController;
import nl.com.wimmusic.dashboard.DashboardController;


public class MenuController extends BaseController implements Initializable {

  @FXML HBox layout;

  public MenuController(User user, Database database) {
    super(user, database);
  }

  @FXML
  protected void onDashBoardButtonClick() {
    loadScene("dashboard-view.fxml", new DashboardController(user, database));
  }

  @FXML
  protected void onCreateOrderButtonClick() {
    loadScene("create-order-view.fxml", new OrderController(user, database));
  }

  @FXML
  protected void onProductInventoryClick() {
    loadScene("product-inventory-view.fxml", new ProductInventoryController(user, database));
  }

  @FXML
  protected void onOrderHistoryClick() {
    loadScene("order-history-view.fxml", new OrderHistoryController(user, database));
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loadScene("dashboard-view.fxml", new DashboardController(user, database));
  }
}
