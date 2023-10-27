package nl.com.wimmusic.database;

import java.io.*;
import java.io.Serializable;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import nl.com.wimmusic.model.*;
import nl.com.wimmusic.model.Order;

public class Database implements Serializable {
  private final File DATABASE_FILE =
      new File("src/main/java/nl/com/wimMusic/ui/database.dat");
  private final List<User> userList = new ArrayList<>();
  private final List<Product> products = new ArrayList<>();
  private final List<Order> orders = new ArrayList<>();

  public Database() {
    if (DATABASE_FILE.exists()) loadDatabase();
    else createDatabase();
  }

  private void loadDatabase() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATABASE_FILE))) {
      Object object;
      while ((object = ois.readObject()) != null) {
        if (object instanceof User user) {
          userList.add(user);
        } else if (object instanceof Product product) {
          products.add(product);
        } else if (object instanceof Order order) {
          orders.add(order);
        }
      }
    } catch (EOFException ignored) {
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
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

  private void fillUsers() {
    userList.add(new Manager(1, "manager", "manager1234%", "Wim Wiltenburg"));
    userList.add(new Sales(2, "sales", "sales1234%", "John DoetGewoon"));
  }

  private void fillInstruments() {
    products.add(
        new Product(
            15, "The Cool Guitar", "Made out of the best strings", 102.25, ProductType.Guitars));
    products.add(new Product(20, "The Cool Bass", "Just like the fish!", 55.23, ProductType.Bass));
    products.add(
        new Product(
            25,
            "The Cool Drums",
            "Drum till you make the neighbours deaf!",
            99.99,
            ProductType.Drums));
    products.add(
        new Product(
            35,
            "The Cool Keyboard",
            "You can pretend you know how to play all the instruments!",
            120,
            ProductType.Keyboards));
  }

  protected void saveDatabase() {
    try (FileOutputStream fos = new FileOutputStream(DATABASE_FILE);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      for (User user : userList) {
        oos.writeObject(user);
      }
      for (Product product : products) {
        oos.writeObject(product);
      }
      for (Order order : orders) {
        oos.writeObject(order);
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public List<User> getUsers() {
    return userList;
  }

  public List<Product> getProducts() {
    return products;
  }

  public ObservableList<Order> getOrders() {
    return (ObservableList<Order>) orders;
  }

  public void addOrder(Order order) {
    orders.add(order);
    saveDatabase();
  }


  public void deleteOrder(Order order) {
    orders.remove(order);
    saveDatabase();
  }

  public void deleteProduct(Product product) {
    products.remove(product);
    saveDatabase();
  }

  public void addProduct(Product product) {
    products.add(product);
    saveDatabase();
  }

  public void updateProductStock(Product product, int quantity) {
    int newStock = product.getStock() - quantity;
    if (newStock < 0) {


        } else {
        product.setStock(newStock);
    }
    saveDatabase();
  }
}
