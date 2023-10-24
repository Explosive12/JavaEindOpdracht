package nl.com.wimmusic.productInventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import nl.com.wimmusic.addEditProductController.ProductToDatabaseController;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.Product;
import nl.com.wimmusic.models.User;
import nl.com.wimmusic.ui.BaseController;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductInventoryController extends BaseController implements Initializable {

    @FXML
    private TableView<Product> productTableView;
    public ProductInventoryController(User user, Database database) {
        super(user, database);
    }

    @FXML
    public void onAddButtonClick() {
    loadDialog(
        "add-edit-product-database-view.fxml",
        new ProductToDatabaseController(user, database, null),
        "Wim's Music Dungeon - Add Product");
    }
    @FXML
    public void onEditButtonClick() {
        Product product = productTableView.getSelectionModel().getSelectedItem();
        if (product == null) {
            return;
        }
    loadDialog(
        "add-edit-product-database-view.fxml",
        new ProductToDatabaseController(user, database, product),
        "Wim's Music Dungeon - Edit Product");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Product> instrumentsList =
                FXCollections.observableList(database.getProducts());
        productTableView.setItems(instrumentsList);
    }

    public void updateTable() {
        ObservableList<Product> instrumentsList =
                FXCollections.observableList(database.getProducts());
        productTableView.setItems(instrumentsList);
    }
}
