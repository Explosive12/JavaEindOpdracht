package nl.com.wimmusic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Button loginButton;

  public void onLoginButtonClick(ActionEvent actionEvent) {
    String username = usernameField.getText();
    String password = passwordField.getText();

    loginButton.setText("Works");
  }

  @FXML
  public void onPasswordTextChange(StringProperty observable, String oldValue, String newValue) {
    loginButton.setDisable(true);
    if (newValue.length() < 8){ return; }
    if ((newValue.matches("^[a-zA-Z0-9]*$"))) { return; }
    if ((newValue.matches("^[a-zA-Z]*$"))) { return; }
    loginButton.setDisable(false);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {}
}
