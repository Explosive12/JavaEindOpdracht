package nl.com.wimmusic.createOrder;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nl.com.wimmusic.addProduct.ProductController;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.*;
import nl.com.wimmusic.ui.BaseController;

public class OrderController extends BaseController implements Initializable {

  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField emailLabelField;
  @FXML private TextField phoneNumberField;
  @FXML private Label errorTextBoxLabel;
  @FXML private TableView<OrderItem> productTableView;

  private Customer customer;
  private final Order order;

  public OrderController(User user, Database database) {
    super(user, database);
    order = new Order(customer);
    OrderService orderService = new OrderService(order);
    orderService.addProductToOrder(new Product(15,"Guitar","test",100,ProductType.Guitars ), 1);
  }

  @FXML
  protected void onAddProductButtonClick(ActionEvent event) {

    loadDialog(
        "add-product-view.fxml",
        new ProductController(user, database, order),
        "Wim's Music Dungeon - Add Product");
    productTableView.refresh();
  }


  private boolean filledIn() {
    return !firstNameField.getText().isEmpty()
        && !lastNameField.getText().isEmpty()
        && !emailLabelField.getText().isEmpty()
        && !phoneNumberField.getText().isEmpty();
  }

  @FXML
  protected void onDeleteProductButtonClick(ActionEvent event) {
    OrderItem orderItem = productTableView.getSelectionModel().getSelectedItem();
    if (orderItem == null) {
      return;
    }
    OrderService orderService = new OrderService(order);
    orderService.removeProductFromOrder(order.getOrderItems(), orderItem);
  }
private Customer createCustomer() {
    return new Customer(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailLabelField.getText(),
                    phoneNumberField.getText());
  }
  @FXML
  protected void onCreateOrderButtonClick(ActionEvent event) {
    if (!filledIn()) {
      errorTextBoxLabel.setVisible(true);
      return;
    }
    errorTextBoxLabel.setVisible(false);

    order.setCustomer(createCustomer());

    database.addOrder(order);
    System.out.println("Order created");
    loadScene("create-order-view.fxml", new OrderController(user, database));
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    errorTextBoxLabel.setVisible(false);
    List<OrderItem> orderItems = order.getOrderItems();
    ObservableList<OrderItem> productList =
        FXCollections.observableList(orderItems);
    productTableView.setItems(productList);
  }
}
