module com.example.mastermind {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.json;

    opens com.example.mastermind to javafx.fxml;
    exports com.example.mastermind;
}