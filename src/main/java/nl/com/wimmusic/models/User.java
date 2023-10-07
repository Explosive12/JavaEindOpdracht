package nl.com.wimmusic.models;

import java.io.Serializable;
import java.time.LocalDate;

public class User extends Person implements Serializable {
    private String userName;
    private String password;


    public User(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
