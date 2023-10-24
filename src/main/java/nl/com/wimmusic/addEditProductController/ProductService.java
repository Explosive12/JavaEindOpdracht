package nl.com.wimmusic.addEditProductController;

import nl.com.wimmusic.database.Database;
import nl.com.wimmusic.models.Product;

public class ProductService {

    Product product;

    ProductService(Product product) {
        this.product = product;
    }

    public void addProductToDatabase(Database database) {
        database.addProduct(product);
    }
}
