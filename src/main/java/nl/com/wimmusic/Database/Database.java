package nl.com.wimmusic.Database;

import nl.com.wimmusic.models.Instrument;
import nl.com.wimmusic.models.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final File DATABASE_FILE = new File("src/main/resources/com/WimMusic/ui/wimDatabase.dat");
    private final List<Person> people = new ArrayList<>();
    private final List<Instrument> instruments = new ArrayList<>();

    public Database() {
        if (!DATABASE_FILE.exists()) {
            createDatabase();
        }
    }
    public List<Person> getPeople() {
        return people;
    }
    private void createDatabase() {
        try {
            Files.createFile(DATABASE_FILE.toPath());
        } catch (FileAlreadyExistsException NoDuplicates) {
            System.out.println("File couldn't be deleted, so overwriting is NOW");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        fillPeople();
        fillInstruments();
    }

    private void fillPeople() {
    }

    private void fillInstruments() {}



    protected void addPerson(Person person) {
        people.add(person);
    }

}
