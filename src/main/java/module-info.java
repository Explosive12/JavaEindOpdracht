module nl.com.wimmusic {
  requires javafx.controls;
  requires javafx.fxml;

  opens nl.com.wimmusic to
      javafx.fxml;

  exports nl.com.wimmusic;
    exports nl.com.wimmusic.ui;
    opens nl.com.wimmusic.ui to javafx.fxml;
  exports nl.com.wimmusic.productInventory;
    opens nl.com.wimmusic.productInventory to javafx.fxml;
  exports nl.com.wimmusic.orderHistory;
  opens nl.com.wimmusic.orderHistory to javafx.fxml;
  exports nl.com.wimmusic.menu;
  opens nl.com.wimmusic.menu to javafx.fxml;
  exports nl.com.wimmusic.login;
  opens nl.com.wimmusic.login to javafx.fxml;
  exports nl.com.wimmusic.dashboard;
  opens nl.com.wimmusic.dashboard to javafx.fxml;
  exports nl.com.wimmusic.createOrder;
  exports nl.com.wimmusic.addProduct;
  opens nl.com.wimmusic.addProduct to javafx.fxml;
  opens nl.com.wimmusic.createOrder to javafx.base,javafx.fxml;
  exports nl.com.wimmusic.models;
  opens nl.com.wimmusic.models to javafx.base,javafx.fxml;
  opens nl.com.wimmusic.addEditProductController to javafx.fxml;
    exports nl.com.wimmusic.addEditProductController;

}
