package nl.com.wimmusic.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.Customer;
import nl.com.wimmusic.models.Instrument;
import nl.com.wimmusic.models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController extends BaseController implements Initializable {

    private Customer customer;
    @FXML
    TableView<Instrument> productTableView;
    @FXML
    Button cancelButton;
    @FXML Button addToOrderButton;
    @FXML
    TextField quantityTextField;
    public AddProductController(User user, Database database, Customer customer) {
        super(user, database);
        this.customer = customer;
    }

    public void onAddOrderButtonClick() {
        Instrument instrument = productTableView.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityTextField.getText());
    database.addProductToOrder(customer, instrument, quantity);
    }

    public void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Instrument> instrumentsList =
                FXCollections.observableList(database.getInstruments());
        productTableView.setItems(instrumentsList);
    }
}
