package nl.com.wimmusic.models;

import java.time.LocalDate;
import java.util.Map;

public class Manager extends User {
    public Manager(int id, Map<Integer, Instrument> instruments, String userName, String password, String firstName, String lastName, LocalDate birthDate) {
        super(id, instruments, userName, password, firstName, lastName, birthDate);
        this.userRole = UserRoles.Manager;
    }
}
