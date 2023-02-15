module com.example.mastermind {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.json;
    requires com.google.gson;

    opens com.example.mastermind to javafx.fxml;
    exports com.example.mastermind;
    exports com.example.mastermind.entity;
    opens com.example.mastermind.entity to javafx.fxml;
}