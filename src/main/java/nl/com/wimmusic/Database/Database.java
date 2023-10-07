package nl.com.wimmusic.Database;

import nl.com.wimmusic.models.Person;
import nl.com.wimmusic.models.UserRole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {


    private List<Person> people = new ArrayList<>();
    public List<Person> getPeople() {
        return people;
    }

    protected void fillDatabase() {
        people.add(new Person("admin", "Sully", "1234", LocalDate.of(1991, 3, 25), UserRole.Admin));
        people.add(new Person("sales", "Wim Wiltenburg", "2345", LocalDate.of(1973, 11, 14), UserRole.Sales));
        people.add(new Person("customer", "Jan Dammen", "3456", LocalDate.of(2000, 1, 2), UserRole.Sales));
        people.add(new Person("customer", "Steve Jobs", "4567", LocalDate.of(1230, 8, 6), UserRole.Customer));
    }
    protected void addPerson(Person person) {
        people.add(person);
    }

}
