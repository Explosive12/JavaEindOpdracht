module nl.com.wimmusic {
  requires javafx.controls;
  requires javafx.fxml;

  opens nl.com.wimmusic to
      javafx.fxml;

  exports nl.com.wimmusic;
    exports nl.com.wimmusic.ui;
  exports nl.com.wimmusic.model;
  opens nl.com.wimmusic.model to javafx.base,javafx.fxml;
  exports nl.com.wimmusic.service;
  opens nl.com.wimmusic.service to javafx.base,javafx.fxml;
  opens nl.com.wimmusic.ui to javafx.base,javafx.fxml;
}
