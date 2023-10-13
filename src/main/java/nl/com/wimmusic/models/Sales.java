package nl.com.wimmusic.models;

import java.time.LocalDate;
import java.util.Map;

public class Sales extends User {


    public Sales(int id, Map<Integer, Instrument> instruments, String userName, String password, String firstName, String lastName, LocalDate birthDate) {
        super(id, instruments, userName, password, firstName, lastName, birthDate);
        this.userRole = UserRoles.Sales;
    }
}
