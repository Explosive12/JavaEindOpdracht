package nl.com.wimmusic.service;

import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.model.Product;

public class ProductService {

  Product product;

  public ProductService(Product product) {
    this.product = product;
  }

  public void addProductToDatabase(Database database, Product product) {
    database.addProduct(product);
  }
}
