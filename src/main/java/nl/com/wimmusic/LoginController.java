package nl.com.wimmusic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class LoginController {
    @FXML
    private Label welcomeText;


    @FX
    protected void onLoginButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}