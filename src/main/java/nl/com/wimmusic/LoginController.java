package nl.com.wimmusic;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    protected void onPasswordTextChange(StringProperty observable, String oldValue, String newValue) {

    }

    @FXML
    protected void onLoginButtonClick(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        loginButton.setText("Works");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}