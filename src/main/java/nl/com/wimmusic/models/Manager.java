package nl.com.wimmusic.models;

import java.time.LocalDate;
import java.util.Map;

public class Manager extends User {

    public Manager(int id, String userName, String password, String name) {
        super(id, userName, password, name);
        this.userRole = UserRoles.Manager;
    }
}
