package nl.com.wimmusic.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.com.wimmusic.Exception.CantFindFXMLException;
import nl.com.wimmusic.WimMusicApplication;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.menu.MenuController;
import nl.com.wimmusic.models.User;

public class LoginController implements Initializable {
  private final ObservableList<User> userList;
  private final Database database;
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Button loginButton;
  @FXML private Label loginFailedLabel;

    public LoginController() {
    database = new Database();
    userList = FXCollections.observableArrayList(database.getUsers());
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
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        loadWimMusic(user);
        return;
      }
    }
    loginFailedLabel.setVisible(true);
  }

  private void loadWimMusic(User user) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(WimMusicApplication.class.getResource("menu-view.fxml"));
      MenuController menuController = new MenuController(user, database);
      fxmlLoader.setController(menuController);
      Stage stage = new Stage();
      Scene scene = new Scene(fxmlLoader.load());

      stage.setScene(scene);
      stage.setTitle("Wim's music dungeon - Dashboard");
      stage.showAndWait();
    } catch (IOException e) {
      throw new CantFindFXMLException("Cannot find the FXML file", e);
    } catch (Exception e) {
      System.err.println("Error loading FXML: " + e.getMessage());
      e.printStackTrace();
    }
  }
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
