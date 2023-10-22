package nl.com.wimmusic.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.Instrument;
import nl.com.wimmusic.models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController extends BaseController implements Initializable {

    @FXML
    TableView<Instrument> productTableView;
    public AddProductController(User user, Database database) {
        super(user, database);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Instrument> instrumentsList =
                FXCollections.observableList(database.getInstruments());
        productTableView.setItems(instrumentsList);
    }
}
