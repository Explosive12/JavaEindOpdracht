package nl.com.wimmusic.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import nl.com.wimmusic.Exception.CantFindFXMLException;
import nl.com.wimmusic.WimMusicApplication;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;

import java.io.IOException;

public class BaseController {

    @FXML
    protected HBox layout;
    protected User user;
    protected Database database;

    public BaseController(User user, Database database) {
        this.user = user;
        this.database = database;
    }

    public void loadScene(String name, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WimMusicApplication.class.getResource(name));
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load());
            if (layout.getChildren().size() > 1)
                layout.getChildren().remove(1);
            layout.getChildren().add(scene.getRoot());
        } catch (CantFindFXMLException | IOException  e) {
            throw new RuntimeException(e);
        }
    }
}
