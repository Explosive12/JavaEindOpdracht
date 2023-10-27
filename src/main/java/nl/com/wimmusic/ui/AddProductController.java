package nl.com.wimmusic.ui;

import java.net.URL;
import java.util.ResourceBundle;
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
import nl.com.wimmusic.model.Product;
import nl.com.wimmusic.model.ProductType;
import nl.com.wimmusic.model.User;
import nl.com.wimmusic.service.ProductService;

public class AddProductController extends BaseController implements Initializable {
  private Product product;
  private final ProductInventoryController productInventoryController;
  @FXML private Label addOrEditLabel;
  @FXML private Button addProductButton;
  @FXML private TextField nameTextField;
  @FXML private TextField descriptionTextField;
  @FXML private TextField priceTextField;
  @FXML private ComboBox<ProductType> typeComboBox;
  @FXML private TextField stockTextField;
  @FXML private Label errorLabel;

  public AddProductController(User user, Database database, Product product, ProductInventoryController productInventoryController) {
    super(user, database);
    this.product = product;
    this.productInventoryController = productInventoryController;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ObservableList<ProductType> productTypes =
            FXCollections.observableArrayList(ProductType.values());
    typeComboBox.setItems(productTypes);
    if (product != null) {
      changeToEditScene();
    }
  }

  public void onTextChange(){
    nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\sa-zA-Z*")) {
        nameTextField.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
      }
    });
  descriptionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\sa-zA-Z*")) {
        descriptionTextField.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
      }
    });
    priceTextField.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d*\\.?\\d*")) {
        priceTextField.setText(newValue.replaceAll("[^\\d.]", ""));
      }
    });
    stockTextField.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d*")) {
        stockTextField.setText(newValue.replaceAll("[^\\d]", ""));
      }
    });
    }
  // Buttons
  @FXML
  protected void onCancelButtonClick(ActionEvent event) {
    Stage stage = (Stage) addOrEditLabel.getScene().getWindow();
    stage.close();
  }

  @FXML
  protected void onAddEditProductButton(ActionEvent event) {
    try {
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
        productInventoryController.updateProductList(product);
      Stage stage = (Stage) addOrEditLabel.getScene().getWindow();
      stage.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private boolean isFilledIn() {
    return !nameTextField.getText().isBlank()
        && !descriptionTextField.getText().isBlank()
        && !priceTextField.getText().isEmpty()
        && !typeComboBox.getSelectionModel().isEmpty()
        && !stockTextField.getText().isBlank();
  }

  // Create part
  private void createProduct() {
    product =
        new Product(
            Integer.parseInt(stockTextField.getText()),
            nameTextField.getText(),
            descriptionTextField.getText(),
            Double.parseDouble(priceTextField.getText()),
            typeComboBox.getSelectionModel().getSelectedItem());
  }

  // Edit part
  private void editProduct() {
    product.setStock(Integer.parseInt(stockTextField.getText()));
    product.setName(nameTextField.getText());
    product.setDescription(descriptionTextField.getText());
    product.setPrice(Double.parseDouble(priceTextField.getText()));
    product.setType(typeComboBox.getSelectionModel().getSelectedItem());
  }

  private void changeToEditScene() {
    addOrEditLabel.setText("Edit Product");
    addProductButton.setText("Edit Product");
    nameTextField.setText(product.getName());
    descriptionTextField.setText(product.getDescription());
    priceTextField.setText(String.valueOf(product.getPrice()));
    typeComboBox.getSelectionModel().select(product.getType());
    stockTextField.setText(String.valueOf(product.getStock()));
  }
}
