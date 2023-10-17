package nl.com.wimmusic.ui;

import javafx.scene.Parent;
import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;

public class DashboardController extends BaseController {


    DashboardController(User user, Database database) {
        super(user, database);
    }

}
