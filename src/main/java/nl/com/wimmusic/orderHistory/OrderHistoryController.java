package nl.com.wimmusic.orderHistory;

import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.User;
import nl.com.wimmusic.ui.BaseController;

public class OrderHistoryController extends BaseController {
    public OrderHistoryController(User user, Database database) {
        super(user, database);
    }
}
