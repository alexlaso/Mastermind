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
import org.json.JSONObject;

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
    private BooleanosCorrectos booleanosCorrectos;
    private BooleanosExisten booleanosExisten;

    @FXML
    private void enviarIntento(){
        switch(intento) {
            case 1:
            intento1color1.setStyle("-fx-background-color: black");
                //Aqui tengo que mandar el codigo al server para que compruebe el intento
                comprobarEleccion();
                try {
                    crearFeedback();
                    System.out.println(booleanosCorrectos.toString());
                    System.out.println(booleanosExisten.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
            case 4:
                intento4color1.setStyle("-fx-background-color: black");
                intento4color2.setStyle("-fx-background-color: #333333");
                intento4color3.setStyle("-fx-background-color: #656565");
                intento4color4.setStyle("-fx-background-color: #9C9C9C");
                intento4color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 5:
                intento5color1.setStyle("-fx-background-color: black");
                intento5color2.setStyle("-fx-background-color: #333333");
                intento5color3.setStyle("-fx-background-color: #656565");
                intento5color4.setStyle("-fx-background-color: #9C9C9C");
                intento5color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 6:
                intento6color1.setStyle("-fx-background-color: black");
                intento6color2.setStyle("-fx-background-color: #333333");
                intento6color3.setStyle("-fx-background-color: #656565");
                intento6color4.setStyle("-fx-background-color: #9C9C9C");
                intento6color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 7:
                intento7color1.setStyle("-fx-background-color: black");
                intento7color2.setStyle("-fx-background-color: #333333");
                intento7color3.setStyle("-fx-background-color: #656565");
                intento7color4.setStyle("-fx-background-color: #9C9C9C");
                intento7color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 8:
                intento8color1.setStyle("-fx-background-color: black");
                intento8color2.setStyle("-fx-background-color: #333333");
                intento8color3.setStyle("-fx-background-color: #656565");
                intento8color4.setStyle("-fx-background-color: #9C9C9C");
                intento8color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 9:
                intento9color1.setStyle("-fx-background-color: black");
                intento9color2.setStyle("-fx-background-color: #333333");
                intento9color3.setStyle("-fx-background-color: #656565");
                intento9color4.setStyle("-fx-background-color: #9C9C9C");
                intento9color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
            case 10:
                intento10color1.setStyle("-fx-background-color: black");
                intento10color2.setStyle("-fx-background-color: #333333");
                intento10color3.setStyle("-fx-background-color: #656565");
                intento10color4.setStyle("-fx-background-color: #9C9C9C");
                intento10color5.setStyle("-fx-background-color: #FFFFFF");
                comprobarEleccion();
                intento++;
                break;
        }

    }

    private void comprobarEleccion() {
        if(color1picker.getValue()!=null && color2picker.getValue()!=null && color3picker.getValue()!=null && color4picker.getValue()!=null && color5picker.getValue()!=null)
        {
        Codigo intento = new Codigo(color1picker.getValue(),color2picker.getValue(),color3picker.getValue(),color4picker.getValue(),color5picker.getValue());
        String escritura = gson.toJson(intento);
            System.out.println(escritura);
            color1picker.setValue(null);
            color2picker.setValue(null);
            color3picker.setValue(null);
            color4picker.setValue(null);
            color5picker.setValue(null);
            generarIntento(intento);
        }else{
            System.exit(13);
            System.err.println("Hay información vacía");
        }
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

    public void generarIntento(Codigo intento){
        File f = new File("intento.json");
        try {
            f.createNewFile();
            System.out.println("Fichero creado exitosamente");
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(f));
            JSONObject json = new JSONObject().put("color1",intento.getColor1()).put("color2",intento.getColor2()).put("color3",intento.getColor3()).put("color4",intento.getColor4()).put("color5",intento.getColor5());
            bw.write(json.toString());
            System.out.println("Fichero escrito exitosamente");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearFeedback() throws IOException {
        String jsonsolucion = "";
        String jsonintento = "";

        BufferedReader brSol = new BufferedReader(new FileReader("correctos.json"));
        BufferedReader brInt = new BufferedReader(new FileReader("existen.json"));

        String lineaSol = "";
        String lineaInt = "";

        while ((lineaSol = brSol.readLine()) != null){
            jsonsolucion+=lineaSol;
        }
        while ((lineaInt = brInt.readLine()) != null){
            jsonintento+=lineaInt;
        }

        Gson gson = new Gson();
        booleanosCorrectos = gson.fromJson(jsonsolucion, BooleanosCorrectos.class);
        booleanosExisten = gson.fromJson(jsonintento,BooleanosExisten.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        color1picker.getItems().addAll(lista);
        color2picker.getItems().addAll(lista);
        color3picker.getItems().addAll(lista);
        color4picker.getItems().addAll(lista);
        color5picker.getItems().addAll(lista);
    }
}