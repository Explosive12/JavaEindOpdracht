package nl.com.wimmusic.ui;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.User;

public class DashboardController extends BaseController implements Initializable {

  @FXML private Label welcomeLabel;
  @FXML private Label roleLabel;
  @FXML private Label dateTimeLabel;
  public DashboardController(User user, Database database) {
    super(user, database);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    welcomeLabel.setText("Welcome " + user.getName() + "!");
    roleLabel.setText("Your role is: " + user.getUserRole().toString());
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    dateTimeLabel.setText("It is now: " + dateTime.format(formatter));
  }
}
