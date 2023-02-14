package com.example.mastermind;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    private int intento=1;
    @FXML
    private Pane intento1color1, intento1color2, intento1color3, intento1color4, intento1color5, intento2color1, intento2color2, intento2color3, intento2color4, intento2color5, intento3color1, intento3color2, intento3color3, intento3color4, intento3color5, intento4color1, intento4color2, intento4color3, intento4color4, intento4color5, intento5color1, intento5color2, intento5color3, intento5color4, intento5color5, intento6color1, intento6color2, intento6color3, intento6color4, intento6color5, intento7color1, intento7color2, intento7color3, intento7color4,intento7color5, intento8color1, intento8color2, intento8color3, intento8color4, intento8color5, intento9color1, intento9color2, intento9color3, intento9color4, intento9color5, intento10color1, intento10color2,intento10color3, intento10color4, intento10color5;

    @FXML
    private Button btnEnviar;
    @FXML
    private ComboBox<String> color1picker, color2picker, color3picker, color4picker, color5picker;

    @FXML
    private void enviarIntento(){
        switch(intento) {
            case 1:
            intento1color1.setStyle("-fx-background-color: black");
            intento1color2.setStyle("-fx-background-color: #333333");
            intento1color3.setStyle("-fx-background-color: #656565");
            intento1color4.setStyle("-fx-background-color: #9C9C9C");
            intento1color5.setStyle("-fx-background-color: #FFFFFF");
            intento++;
            break;
            case 2:
                intento2color1.setStyle("-fx-background-color: black");
                intento2color2.setStyle("-fx-background-color: #333333");
                intento2color3.setStyle("-fx-background-color: #656565");
                intento2color4.setStyle("-fx-background-color: #9C9C9C");
                intento2color5.setStyle("-fx-background-color: #FFFFFF");
                intento++;
                break;
            case 3:
                intento3color1.setStyle("-fx-background-color: black");
                intento3color2.setStyle("-fx-background-color: #333333");
                intento3color3.setStyle("-fx-background-color: #656565");
                intento3color4.setStyle("-fx-background-color: #9C9C9C");
                intento3color5.setStyle("-fx-background-color: #FFFFFF");
                intento++;
                break;
        }

    }

    ObservableList<String> lista = FXCollections.observableArrayList(
            "BLUE",
            "WHITE",
            "BLACK",
            "GREEN",
            "RED",
            "YELLOW",
            "PINK"
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        color1picker.getItems().addAll(lista);
        color2picker.getItems().addAll(lista);
        color3picker.getItems().addAll(lista);
        color4picker.getItems().addAll(lista);
        color5picker.getItems().addAll(lista);
    }
}