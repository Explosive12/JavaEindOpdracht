package nl.com.wimmusic.addEditProductController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.Product;
import nl.com.wimmusic.models.ProductType;
import nl.com.wimmusic.models.User;
import nl.com.wimmusic.productInventory.ProductInventoryController;
import nl.com.wimmusic.ui.BaseController;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductToDatabaseController extends BaseController implements Initializable {
  private final Product product;
  @FXML private Label addOrEditLabel;
  @FXML private Button addProductButton;
  @FXML private TextField nameTextField;
  @FXML private TextField descriptionTextField;
  @FXML private TextField priceTextField;
  @FXML private ComboBox<ProductType> typeComboBox;
  @FXML private TextField stockTextField;
  @FXML private Label errorLabel;

  public ProductToDatabaseController(User user, Database database, Product product) {
    super(user, database);
    this.product = product;
  }

  // Buttons
  @FXML public void onCancelButtonClick(ActionEvent event) {
    Stage stage = (Stage) addOrEditLabel.getScene().getWindow();
    stage.close();

  }
  public void onAddEditProductButton(ActionEvent event) {
    if (!isFilledIn()) {
      errorLabel.setVisible(true);
      return;
    }
    errorLabel.setVisible(false);
    if (product == null) {
      createProduct();
    } else {
        editProduct();
    }
    Stage stage = (Stage) addOrEditLabel.getScene().getWindow();
    stage.close();
  }

  private boolean isFilledIn() {
    return !nameTextField.getText().isEmpty()
        && !descriptionTextField.getText().isEmpty()
        && !priceTextField.getText().isEmpty()
        && !typeComboBox.getSelectionModel().isEmpty()
        && !stockTextField.getText().isEmpty();
  }

  // Create part
  private void createProduct() {
    Product newProduct =
        new Product(
            Integer.parseInt(stockTextField.getText()),
            nameTextField.getText(),
            descriptionTextField.getText(),
            Double.parseDouble(priceTextField.getText()),
            typeComboBox.getSelectionModel().getSelectedItem());
    ProductService productService = new ProductService(newProduct);
    productService.addProductToDatabase(database);
  }
  // Edit part
  private void editProduct() {
    product.setStock(Integer.parseInt(stockTextField.getText()));
    product.setName(nameTextField.getText());
    product.setDescription(descriptionTextField.getText());
    product.setPrice(Double.parseDouble(priceTextField.getText()));
    product.setType(typeComboBox.getSelectionModel().getSelectedItem());
  }

  // Initialise part

  private void changeToEditScene() {
    addOrEditLabel.setText("Edit Product");
    addProductButton.setText("Edit Product");
    nameTextField.setText(product.getName());
    descriptionTextField.setText(product.getDescription());
    priceTextField.setText(String.valueOf(product.getPrice()));
    typeComboBox.getSelectionModel().select(product.getType());
    stockTextField.setText(String.valueOf(product.getStock()));
  }
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ObservableList<ProductType> productTypes = FXCollections.observableArrayList(ProductType.values());
    typeComboBox.setItems(productTypes);
    if (product != null) {
      changeToEditScene();
    }
  }
}
