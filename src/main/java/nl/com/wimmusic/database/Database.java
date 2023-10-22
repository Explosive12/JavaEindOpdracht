package nl.com.wimmusic.database;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import nl.com.wimmusic.models.*;

public class Database implements Serializable {
  private static final File DATABASE_FILE = new File("src/main/java/nl/com/wimmusic/database/database.dat");
  private final List<User> userList = new ArrayList<>();
  private final List<Instrument> instruments = new ArrayList<>();

  public Database() {
    if (DATABASE_FILE.exists()) loadDatabase();
    else createDatabase();
  }

  private void fillUsers() {
    userList.add(new Manager(1, "manager", "manager1234%", "Wim Wiltenburg"));
    userList.add(new Sales(2, "sales", "sales1234%", "John DoetGewoon"));
  }

  private void fillInstruments() {
    instruments.add(new Instrument(1, 15, "The Cool Guitar", "Made out of the best strings", 102.25, InstrumentType.Guitars, false));
    instruments.add(new Instrument(2, 20, "The Cool Bass", "Just like the fish!", 55.23, InstrumentType.Bass, false));
    instruments.add(new Instrument(3, 25, "The Cool Drums", "Drum till you make the neighbours deaf!",99.99,InstrumentType.Drums, false));
    instruments.add(new Instrument(4, 35, "The Cool Keyboard", "You can pretend you know how to play all the instruments!",120, InstrumentType.Keyboards, false));
  }

  private void createDatabase() {
    try {
      DATABASE_FILE.createNewFile();
    } catch (FileAlreadyExistsException e) {
        System.out.println("Database (File) already exists");
        } catch (IOException e) {
        e.printStackTrace();
    }
    fillUsers();
    fillInstruments();
    saveDatabase();

  }
  private void loadDatabase() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATABASE_FILE))) {
      while (true) {
        Object object = ois.readObject();
        if (object instanceof User) {
          userList.add((User) object);
        } else if (object instanceof Instrument) {
          instruments.add((Instrument) object);
        }
      }
    } catch (EOFException ignored) {
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  protected void saveDatabase(){
    try (FileOutputStream fos = new FileOutputStream(DATABASE_FILE);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      for (User user : userList) {
        oos.writeObject(user);
      }
      for (Instrument instrument : instruments) {
        oos.writeObject(instrument);
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public List<User> getUsers() {
    return userList;
  }

  public List<Instrument> getInstruments() {
    return instruments;
  }

  public void addProductToOrder(Customer customer, Instrument instrument, int quantity) {
  }
}
