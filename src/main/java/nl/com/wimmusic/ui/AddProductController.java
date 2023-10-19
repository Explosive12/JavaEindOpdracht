package nl.com.wimmusic.ui;

import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;

public class AddProductController extends BaseController {
    public AddProductController(User user, Database database) {
        super(user, database);
    }
}
