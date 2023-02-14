module com.example.mastermind {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.mastermind to javafx.fxml;
    exports com.example.mastermind;
}