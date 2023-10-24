package nl.com.wimmusic.addProduct;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.com.wimmusic.createOrder.OrderService;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.Product;
import nl.com.wimmusic.models.Order;
import nl.com.wimmusic.models.User;
import nl.com.wimmusic.ui.BaseController;

public class ProductController extends BaseController implements Initializable {

  private final Order order;
  @FXML private TableView<Product> productTableView;
  @FXML private Button cancelButton;
  @FXML private Button addToOrderButton;
  @FXML private TextField quantityTextField;
  @FXML private Label errorLabel;

  public ProductController(User user, Database database, Order order) {
    super(user, database);
    this.order = order;
  }

  @FXML
  public void onAddToOrderButtonClick() {
    int quantity = getQuantity();
    Product product = productTableView.getSelectionModel().getSelectedItem();

    if (product == null || quantity == 0) {
      return;
    }

    OrderService orderService = new OrderService(order);
    orderService.addProductToOrder(product, quantity);
    Stage stage = (Stage) addToOrderButton.getScene().getWindow();
    stage.close();
  }
  private int getQuantity() {
    if (quantityTextField.getText().isEmpty()) {
      return 0;
    }
    try {
      Integer.parseInt(quantityTextField.getText());
        return Integer.parseInt(quantityTextField.getText());
    } catch (NumberFormatException e) {
      errorLabel.setVisible(true);
    }
      return 0;
  }

  public void onCancelButtonClick() {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ObservableList<Product> instrumentsList =
        FXCollections.observableList(database.getProducts());
    productTableView.setItems(instrumentsList);
  }
}