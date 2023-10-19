package nl.com.wimmusic.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;


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
    loadScene("create-order-view.fxml", new CreateOrderController(user, database));
  }

  @FXML
  protected void onProductInventoryClick() {
    loadScene("product-inventory-view.fxml", new ProductInventoryController());
  }

  @FXML
  protected void onOrderHistoryClick() {
    loadScene("order-history-view.fxml", new OrderHistoryController());
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loadScene("dashboard-view.fxml", new DashboardController(user, database));
  }
}
