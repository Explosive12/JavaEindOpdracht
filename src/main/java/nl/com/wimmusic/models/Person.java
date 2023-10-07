package nl.com.wimmusic.models;

import java.time.LocalDate;

public class Person {



    private String userName;
    private String name;
    private String password;
    private LocalDate birthDate;
    private UserRole userRole;

    public Person(String userName, String name, String password, LocalDate birthDate, UserRole userRole) {
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.userRole = userRole;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
