package nl.com.wimmusic.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.User;
import nl.com.wimmusic.model.UserRoles;

public class MenuController extends BaseController implements Initializable {

  @FXML private HBox layout;
  @FXML private Button createOrderMenuButton;

  public MenuController(User user, Database database) {
    super(user, database);
  }
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loadScene("dashboard-view.fxml", new DashboardController(user, database));
    if (user.getUserRole() == UserRoles.Manager) {
      createOrderMenuButton.setVisible(false);
    }
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


}
