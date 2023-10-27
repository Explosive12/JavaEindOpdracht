package nl.com.wimmusic.ui;

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
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.*;
import nl.com.wimmusic.service.OrderService;

public class OrderController extends BaseController implements Initializable {

  private final Order order;
  private ObservableList<OrderItem> orderItems;
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField emailLabelField;
  @FXML private TextField phoneNumberField;
  @FXML private Label errorTextBoxLabel;
  @FXML private TableView<OrderItem> productTableView;
  private Customer customer;

  public OrderController(User user, Database database) {
    super(user, database);
    order = new Order(customer);
    OrderService orderService = new OrderService(order);
    orderService.addProductToOrder(new Product(15, "Guitar", "test", 100, ProductType.Guitars), 1);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    errorTextBoxLabel.setVisible(false);

    orderItems = FXCollections.observableArrayList(order.getOrderItems());
    productTableView.setItems(orderItems);
  }

  protected void addProductToOrder(Product product, int quantity) {
    orderItems.add(new OrderItem(product, quantity));
  }

  @FXML
  protected void onAddProductButtonClick(ActionEvent event) {

    AddProductToOrderController productController = new AddProductToOrderController(user, database, this);
    loadDialog("add-product-to-order-view.fxml", productController, "Wim's Music Dungeon - Add Product");
    productTableView.refresh();
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

  @FXML
  protected void onCreateOrderButtonClick(ActionEvent event) {
    if (!filledIn()) {
      errorTextBoxLabel.setVisible(true);
      return;
    }
    errorTextBoxLabel.setVisible(false);

    order.setCustomer(createCustomer());

    loadDialog(
        "order-confirmation-view.fxml",
        new ConfirmOrderDialogController(user, database, order),
        "Wim's Music Dungeon - Order Confirmation");
    System.out.println("Order created");
    loadScene("create-order-view.fxml", new OrderController(user, database));
  }

  private boolean filledIn() {
    return !firstNameField.getText().isBlank()
        && !lastNameField.getText().isBlank()
        && !emailLabelField.getText().isBlank()
        && !phoneNumberField.getText().isBlank();
  }

  private Customer createCustomer() {
    return new Customer(
        firstNameField.getText(),
        lastNameField.getText(),
        emailLabelField.getText(),
        phoneNumberField.getText());
  }


}
