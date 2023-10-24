package nl.com.wimmusic.dashboard;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;
import nl.com.wimmusic.ui.BaseController;

public class DashboardController extends BaseController implements Initializable {

  @FXML Label welcomeLabel;

  @FXML Label roleLabel;

  @FXML Label dateTimeLabel;

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
