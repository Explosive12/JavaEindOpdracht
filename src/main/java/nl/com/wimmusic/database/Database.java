package nl.com.wimmusic.database;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import nl.com.wimmusic.models.*;

public class Database {

    private static final File DATABASE_FILE = new File("src/main/resources/com/WimMusic/ui/wimDatabase.dat");
    private final List<User> userList = new ArrayList<>();
    private final List<Instrument> instruments = new ArrayList<>();

    public Database() {
        loadDatabase();
    }

    private void loadDatabase() {
        fillUsers();
        fillInstruments();
    }

    private void fillUsers() {
        userList.add(new Sales(1, null, "sales", "sales1234%", "Sales", "Sales", LocalDate.of(1990, 1, 1)));
        userList.add(new Manager(2, null, "manager", "manager1234%", "Manager", "Manager", LocalDate.of(1990, 2, 2)));
    }

    private void fillInstruments() {
        instruments.add(new Instrument(1, 20, "The Cool Guitar", InstrumentType.Guitars, false));
        instruments.add(new Instrument(2, 20, "The Cool Bass", InstrumentType.Bass, false));
        instruments.add(new Instrument(3, 20, "The Cool Drums", InstrumentType.Drums, false));
        instruments.add(new Instrument(4, 20, "The Cool Keyboard", InstrumentType.Keyboards, false));
    }

    public List<User> getUsers() {
        return userList;
    }

    public List<Instrument> getInstruments() { return instruments; }
}