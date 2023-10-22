package nl.com.wimmusic.ui;

import java.net.URL;
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
import nl.com.wimmusic.models.Instrument;
import nl.com.wimmusic.models.User;

public class CreateOrderController extends BaseController implements Initializable {

  @FXML TextField firstNameField;
  @FXML TextField lastNameField;
  @FXML TextField emailLabelField;
  @FXML TextField phoneNumberField;
  @FXML Label errorTextBoxLabel;
  @FXML TableView<Instrument> productTableView;

  public CreateOrderController(User user, Database database) {
    super(user, database);
  }

  private boolean filledIn() {
    return !firstNameField.getText().isEmpty()
        && !lastNameField.getText().isEmpty()
        && !emailLabelField.getText().isEmpty()
        && !phoneNumberField.getText().isEmpty();
  }

  @FXML
  protected void onAddProductButtonClick(ActionEvent event) {
    if (!filledIn()) {
      errorTextBoxLabel.setVisible(true);
      return;
    }
    errorTextBoxLabel.setVisible(false);
    loadDialog("add-product-view.fxml", new AddProductController(user, database), "Wim's Music Dungeon - Add Product");
  }

  @FXML
  protected void onDeleteProductButtonClick(ActionEvent event) {

  }

  @FXML
  protected void onCreateOrderButtonClick(ActionEvent event) {}

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    errorTextBoxLabel.setVisible(false);
    ObservableList<Instrument> instrumentsList =
        FXCollections.observableList(database.getInstruments());
    productTableView.setItems(instrumentsList);
  }
}
