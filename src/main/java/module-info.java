module nl.com.wimmusic {
  requires javafx.controls;
  requires javafx.fxml;

  opens nl.com.wimmusic to
      javafx.fxml;

  exports nl.com.wimmusic;
    exports nl.com.wimmusic.ui;
    opens nl.com.wimmusic.ui to javafx.fxml;
}
