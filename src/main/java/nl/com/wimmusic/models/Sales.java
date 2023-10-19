package nl.com.wimmusic.models;

import java.time.LocalDate;
import java.util.Map;

public class Sales extends User {


    public Sales(int id, String userName, String password, String name) {
        super(id, userName, password, name);
        this.userRole = UserRoles.Sales;
    }
}
