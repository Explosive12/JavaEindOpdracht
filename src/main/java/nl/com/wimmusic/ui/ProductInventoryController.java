package nl.com.wimmusic.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.Product;
import nl.com.wimmusic.model.User;
import nl.com.wimmusic.service.ProductService;

public class ProductInventoryController extends BaseController implements Initializable {

  @FXML private TableView<Product> productTableView;
  private ObservableList<Product> products;

  public ProductInventoryController(User user, Database database) {
    super(user, database);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    products = FXCollections.observableArrayList(database.getProducts());
    productTableView.setItems(products);
  }

  @FXML
  public void onAddButtonClick() {
    loadDialog(
        "add-edit-product-database-view.fxml",
        new AddProductController(user, database, null, this),
        "Wim's Music Dungeon - Add Product");
    productTableView.refresh();
  }

  @FXML
  public void onEditButtonClick() {
    Product product = productTableView.getSelectionModel().getSelectedItem();
    if (product == null) {
      return;
    }
    loadDialog(
        "add-edit-product-database-view.fxml",
        new AddProductController(user, database, product, this),
        "Wim's Music Dungeon - Edit Product");
    productTableView.refresh();
  }
  @FXML
  public void onDeleteButtonClick() {
    Product product = productTableView.getSelectionModel().getSelectedItem();
    if (product == null) {
      return;
    }
    database.deleteProduct(product);
    productTableView.getItems().remove(product);
  }

  protected void updateProductList(Product product) {
    products.add(product);
    ProductService productService = new ProductService(product);
    productService.addProductToDatabase(database, product);
  }
}
