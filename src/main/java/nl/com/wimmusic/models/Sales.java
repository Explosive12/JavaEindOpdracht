package nl.com.wimmusic.models;

import java.time.LocalDate;
import java.util.Map;

public class Sales extends User {


    public Sales(int id, Map<Integer, Instrument> instruments, String name, LocalDate birthDate, String userName, String password) {
        super(id, instruments, name, birthDate, userName, password);
    }
}
