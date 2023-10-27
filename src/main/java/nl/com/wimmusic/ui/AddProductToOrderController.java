package nl.com.wimmusic.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.Order;
import nl.com.wimmusic.model.Product;
import nl.com.wimmusic.model.User;
import nl.com.wimmusic.service.OrderService;

public class AddProductToOrderController extends BaseController implements Initializable {

  private final OrderController orderController;
  @FXML private TableView<Product> productTableView;
  @FXML private Button cancelButton;
  @FXML private Button addToOrderButton;
  @FXML private TextField quantityTextField;
  @FXML private Label errorLabel;

  public AddProductToOrderController(User user, Database database, OrderController orderController ) {
    super(user, database);
    this.orderController = orderController;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ObservableList<Product> instrumentsList = FXCollections.observableList(database.getProducts());
    productTableView.setItems(instrumentsList);
  }

  @FXML
  protected void onAddToOrderButtonClick() {
    int quantity = getQuantity();
    Product product = productTableView.getSelectionModel().getSelectedItem();

    if (product == null || quantity == 0) {
      return;
    }
    orderController.addProductToOrder(product, quantity);

    Stage stage = (Stage) addToOrderButton.getScene().getWindow();
    stage.close();
  }

  private int getQuantity() {
    int quantity = 0;
    String quantityString = quantityTextField.getText();

    if (!quantityString.isBlank()) {
      try {
        quantity = Integer.parseInt(quantityString);
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();

        if (quantity < 1 || quantity > selectedProduct.getStock()) {
          errorLabel.setVisible(true);
          return 0;
        }
      } catch (NumberFormatException e) {
        errorLabel.setVisible(true);
      }
    }
    return quantity;
  }

  @FXML protected void onCancelButtonClick() {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
  }


}
