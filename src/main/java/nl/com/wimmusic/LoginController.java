package nl.com.wimmusic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.com.wimmusic.Database.Database;
import nl.com.wimmusic.models.User;

public class LoginController implements Initializable {
  private final ObservableList<User> userList;
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Button loginButton;

  @FXML private Label loginFailedLabel;

  public LoginController() {
    Database db = new Database();
    userList = FXCollections.observableList(db.getUsers());
  }


  @FXML
  public void onPasswordTextChange(StringProperty observable, String oldValue, String newValue) {
    loginButton.setDisable(true);
    loginFailedLabel.setVisible(false);
    if (newValue.length() < 8){ return; }
    if ((newValue.matches("^[a-zA-Z0-9]*$"))) { return; } // checks for special characters
    if ((newValue.matches("^[a-zA-Z]*$"))) { return; } // checks for numbers
    loginButton.setDisable(false);
  }

  public void onLoginButtonClick(ActionEvent actionEvent) {
    String username = usernameField.getText();
    String password = passwordField.getText();

    login(username, password);
  }

  private void login(String username, String password) {
    for (User user : userList) {
      if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
        System.out.println("Login successful");

        // check what role the user is
        // if user is a sales person, open sales view
        // if user is a manager, open manager view
        // if user is a musician, open musician view

        return;
      }
    }
    loginFailedLabel.setVisible(true);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
