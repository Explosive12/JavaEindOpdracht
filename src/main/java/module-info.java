module nl.com.wimmusic {
  requires javafx.controls;
  requires javafx.fxml;

  opens nl.com.wimmusic to
      javafx.fxml;

  exports nl.com.wimmusic;
}
