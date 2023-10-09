package nl.com.wimmusic;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WimMusicApplication extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws IOException {

    try {
      FXMLLoader fxmlLoader =
          new FXMLLoader(WimMusicApplication.class.getResource("login-view.fxml"));
      fxmlLoader.setController(new LoginController());
      Scene scene = new Scene(fxmlLoader.load());

      stage.setTitle("Login");
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace(); // Handle the exception appropriately
    }
  }
}
