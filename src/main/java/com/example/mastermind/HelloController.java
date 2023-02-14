package com.example.mastermind;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    private int intento=1;
    Gson gson=new Gson();

    @FXML
    private VBox fondo;
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
                comprobarRespuesta();
                comprobarEleccion();
                intento++;
            break;
            case 2:
                intento2color1.setStyle("-fx-background-color: black");
                intento2color2.setStyle("-fx-background-color: #333333");
                intento2color3.setStyle("-fx-background-color: #656565");
                intento2color4.setStyle("-fx-background-color: #9C9C9C");
                intento2color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 3:
                intento3color1.setStyle("-fx-background-color: black");
                intento3color2.setStyle("-fx-background-color: #333333");
                intento3color3.setStyle("-fx-background-color: #656565");
                intento3color4.setStyle("-fx-background-color: #9C9C9C");
                intento3color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
        }

    }

    private void comprobarEleccion() {
        if(color1picker.getValue()!=null && color2picker.getValue()!=null && color3picker.getValue()!=null && color4picker.getValue()!=null && color5picker.getValue()!=null)
        {
        Codigo codigo = new Codigo(color1picker.getValue(),color2picker.getValue(),color3picker.getValue(),color4picker.getValue(),color5picker.getValue());
        String escritura = gson.toJson(codigo);
            System.out.println(escritura);
            color1picker.setValue(null);
            color2picker.setValue(null);
            color3picker.setValue(null);
            color4picker.setValue(null);
            color5picker.setValue(null);
        }else{
            System.exit(13);
            System.err.println("Hay información vacía");
        }
    }

    private void comprobarRespuesta(){
        Gson gson = new Gson();
        String json ="";
        try {
            BufferedReader br = new BufferedReader(new FileReader("solucion.json"));

            String linea = "";
            while ((linea = br.readLine()) != null){
                json += linea;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Codigo solucion = gson.fromJson(json, Codigo.class);
    }
    ObservableList<String> lista = FXCollections.observableArrayList(
            "BLUE",
            "WHITE",
            "BLACK",
            "GREEN",
            "RED",
            "YELLOW",
            "PINK",
            "PURPLE"
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