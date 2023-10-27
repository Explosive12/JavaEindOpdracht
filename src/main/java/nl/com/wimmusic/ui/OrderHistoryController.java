package nl.com.wimmusic.ui;

import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.User;

public class OrderHistoryController extends BaseController {
  public OrderHistoryController(User user, Database database) {
    super(user, database);
  }
}
