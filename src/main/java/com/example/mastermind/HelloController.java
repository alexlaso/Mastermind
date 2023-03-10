package com.example.mastermind;

import com.example.mastermind.entity.BooleanosCorrectos;
import com.example.mastermind.entity.BooleanosExisten;
import com.example.mastermind.entity.Codigo;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable{
    private int intento=0;
    Gson gson=new Gson();

    @FXML
    private VBox fondo;
    @FXML
    private Pane intento1color1, intento1color2, intento1color3, intento1color4, intento1color5, intento2color1, intento2color2, intento2color3, intento2color4, intento2color5, intento3color1, intento3color2, intento3color3, intento3color4, intento3color5, intento4color1, intento4color2, intento4color3, intento4color4, intento4color5, intento5color1, intento5color2, intento5color3, intento5color4, intento5color5, intento6color1, intento6color2, intento6color3, intento6color4, intento6color5, intento7color1, intento7color2, intento7color3, intento7color4,intento7color5, intento8color1, intento8color2, intento8color3, intento8color4, intento8color5, intento9color1, intento9color2, intento9color3, intento9color4, intento9color5, intento10color1, intento10color2,intento10color3, intento10color4, intento10color5, color1Final, color2Final, color3Final, color4Final, color5Final;

    @FXML
    private Button btnEnviar;
    @FXML
    private ComboBox<String> color1picker, color2picker, color3picker, color4picker, color5picker;
    DataOutputStream out;
    Receptor receptor;
    boolean col1Good = false, col2Good = false, col3Good = false, col4Good = false, col5Good = false, allGood = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        color1picker.getItems().addAll(lista);
        color2picker.getItems().addAll(lista);
        color3picker.getItems().addAll(lista);
        color4picker.getItems().addAll(lista);
        color5picker.getItems().addAll(lista);


        Socket socket;
        String hostname;
        int port;

        hostname = "localhost";
        try {
            port = 4567;
        }catch (NumberFormatException nfe){
            System.out.println("Introduzca un n??mero de puerto");
            return;
        }

        try{
            socket = new Socket(hostname,port);
        }catch (UnknownHostException uhe){
            System.out.println("No se de que me estas hablando. " + uhe.getMessage());
            return;
        }catch(IOException ioe){
            System.out.println("Error al crear el canal de E/S. " + ioe.getMessage());
            return;
        }

        System.out.println("Conectando desde: ");
        System.out.println(socket.getLocalAddress()+" : "+socket.getLocalPort());
        System.out.println("a");
        System.out.println(socket.getInetAddress() + " : "+socket.getPort());

        try{
            receptor = new Receptor(socket.getInputStream(), this);
            new Thread(receptor).start();
        } catch (IOException e) {
            System.out.println("No se ha podido alcanzar el canal de lectura.");
            return;
        }

        try {
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("canal de escritura creado");
        } catch (IOException e) {
            System.out.println("No se puede obtener el canal de escritura sobre el socket.");
            try{
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }return;
        }
    }

    @FXML
    private void enviarIntento(){
        switch(intento) {
            case 0:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
            break;
            case 1:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 2:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 3:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 4:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 5:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 6:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 7:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 8:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 9:
                try {
                    out.writeUTF("comprueba");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                comprobarEleccion();
                intento++;
                break;
            case 10:
                System.out.println("GAME OVER");
                System.exit(3);
        }

    }

    private void comprobarEleccion() {
        if(color1picker.getValue()==null){
            System.err.println("Hay informaci??n vac??a, se han autocompletado a BLACK");
            color1picker.setValue("BLACK");
        }
        if (color2picker.getValue()==null){
            System.err.println("Hay informaci??n vac??a, se han autocompletado a BLACK");
            color2picker.setValue("BLACK");
        }
        if (color3picker.getValue()==null){
            System.err.println("Hay informaci??n vac??a, se han autocompletado a BLACK");
            color3picker.setValue("BLACK");
        }
        if (color4picker.getValue()==null){
            System.err.println("Hay informaci??n vac??a, se han autocompletado a BLACK");
            color4picker.setValue("BLACK");
        }
        if (color5picker.getValue()==null){
            System.err.println("Hay informaci??n vac??a, se han autocompletado a BLACK");
            color5picker.setValue("BLACK");
        }
        Codigo intento = new Codigo(color1picker.getValue(),color2picker.getValue(),color3picker.getValue(),color4picker.getValue(),color5picker.getValue());
        String escritura = gson.toJson(intento);
            System.out.println(escritura.toString());
            color1picker.setValue(null);
            color2picker.setValue(null);
            color3picker.setValue(null);
            color4picker.setValue(null);
            color5picker.setValue(null);
            generarIntento(intento);
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
        JSONObject json = new JSONObject().put("color1",intento.getColor1()).put("color2",intento.getColor2()).put("color3",intento.getColor3()).put("color4",intento.getColor4()).put("color5",intento.getColor5());
        System.out.println("Antes de enviar");
        try {
            out.writeUTF(json.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Despues");
    }



    public void comprobarAcertados(BooleanosCorrectos booleanosCorrectos, Codigo solucionOculta){
        if (booleanosCorrectos.isColor1Correcto()){color1Final.setStyle("-fx-background-color: "+solucionOculta.getColor1());
        col1Good=true;}
        if (booleanosCorrectos.isColor2Correcto()){color2Final.setStyle("-fx-background-color: "+solucionOculta.getColor2());
        col2Good=true;}
        if (booleanosCorrectos.isColor3Correcto()){color3Final.setStyle("-fx-background-color: "+solucionOculta.getColor3());
        col3Good=true;}
        if (booleanosCorrectos.isColor4Correcto()){color4Final.setStyle("-fx-background-color: "+solucionOculta.getColor4());
        col4Good=true;}
        if (booleanosCorrectos.isColor5Correcto()){color5Final.setStyle("-fx-background-color: "+solucionOculta.getColor5());
        col5Good=true;}
        if(col1Good && col2Good && col3Good && col4Good && col5Good){allGood=true;}
        if(allGood){
            color1picker.setDisable(true);
            color2picker.setDisable(true);
            color3picker.setDisable(true);
            color4picker.setDisable(true);
            color5picker.setDisable(true);
            btnEnviar.setDisable(true);
        }
    }

    public void arte(BooleanosCorrectos booleanosCorrectos, BooleanosExisten booleanosExisten, Codigo solucionOculta){
        switch (intento){
            case 1:
                if (booleanosCorrectos.isColor1Correcto()){intento1color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento1color1.setStyle("-fx-background-color: YELLOW");}
                else{intento1color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento1color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento1color2.setStyle("-fx-background-color: YELLOW");}
                else{intento1color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento1color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento1color3.setStyle("-fx-background-color: YELLOW");}
                else{intento1color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento1color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento1color4.setStyle("-fx-background-color: YELLOW");}
                else{intento1color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento1color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento1color5.setStyle("-fx-background-color: YELLOW");}
                else{intento1color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 2:
                if (booleanosCorrectos.isColor1Correcto()){intento2color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento2color1.setStyle("-fx-background-color: YELLOW");}
                else{intento2color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento2color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento2color2.setStyle("-fx-background-color: YELLOW");}
                else{intento2color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento2color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento2color3.setStyle("-fx-background-color: YELLOW");}
                else{intento2color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento2color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento2color4.setStyle("-fx-background-color: YELLOW");}
                else{intento2color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento2color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento2color5.setStyle("-fx-background-color: YELLOW");}
                else{intento2color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 3:
                if (booleanosCorrectos.isColor1Correcto()){intento3color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento3color1.setStyle("-fx-background-color: YELLOW");}
                else{intento3color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento3color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento3color2.setStyle("-fx-background-color: YELLOW");}
                else{intento3color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento3color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento3color3.setStyle("-fx-background-color: YELLOW");}
                else{intento3color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento3color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento3color4.setStyle("-fx-background-color: YELLOW");}
                else{intento3color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento3color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento3color5.setStyle("-fx-background-color: YELLOW");}
                else{intento3color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 4:
                if (booleanosCorrectos.isColor1Correcto()){intento4color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento4color1.setStyle("-fx-background-color: YELLOW");}
                else{intento4color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento4color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento4color2.setStyle("-fx-background-color: YELLOW");}
                else{intento4color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento4color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento4color3.setStyle("-fx-background-color: YELLOW");}
                else{intento4color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento4color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento4color4.setStyle("-fx-background-color: YELLOW");}
                else{intento4color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento4color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento4color5.setStyle("-fx-background-color: YELLOW");}
                else{intento4color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 5:
                if (booleanosCorrectos.isColor1Correcto()){intento5color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento5color1.setStyle("-fx-background-color: YELLOW");}
                else{intento5color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento5color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento5color2.setStyle("-fx-background-color: YELLOW");}
                else{intento5color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento5color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento5color3.setStyle("-fx-background-color: YELLOW");}
                else{intento5color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento5color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento5color4.setStyle("-fx-background-color: YELLOW");}
                else{intento5color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento5color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento5color5.setStyle("-fx-background-color: YELLOW");}
                else{intento5color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 6:
                if (booleanosCorrectos.isColor1Correcto()){intento6color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento6color1.setStyle("-fx-background-color: YELLOW");}
                else{intento6color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento6color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento6color2.setStyle("-fx-background-color: YELLOW");}
                else{intento6color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento6color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento6color3.setStyle("-fx-background-color: YELLOW");}
                else{intento6color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento6color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento6color4.setStyle("-fx-background-color: YELLOW");}
                else{intento6color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento6color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento6color5.setStyle("-fx-background-color: YELLOW");}
                else{intento6color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 7:
                if (booleanosCorrectos.isColor1Correcto()){intento7color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento7color1.setStyle("-fx-background-color: YELLOW");}
                else{intento7color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento7color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento7color2.setStyle("-fx-background-color: YELLOW");}
                else{intento7color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento7color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento7color3.setStyle("-fx-background-color: YELLOW");}
                else{intento7color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento7color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento7color4.setStyle("-fx-background-color: YELLOW");}
                else{intento7color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento7color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento7color5.setStyle("-fx-background-color: YELLOW");}
                else{intento7color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 8:
                if (booleanosCorrectos.isColor1Correcto()){intento8color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento8color1.setStyle("-fx-background-color: YELLOW");}
                else{intento8color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento8color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento8color2.setStyle("-fx-background-color: YELLOW");}
                else{intento8color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento8color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento8color3.setStyle("-fx-background-color: YELLOW");}
                else{intento8color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento8color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento8color4.setStyle("-fx-background-color: YELLOW");}
                else{intento8color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento8color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento8color5.setStyle("-fx-background-color: YELLOW");}
                else{intento8color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 9:
                if (booleanosCorrectos.isColor1Correcto()){intento9color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento9color1.setStyle("-fx-background-color: YELLOW");}
                else{intento9color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento9color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento9color2.setStyle("-fx-background-color: YELLOW");}
                else{intento9color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento9color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento9color3.setStyle("-fx-background-color: YELLOW");}
                else{intento9color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento9color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento9color4.setStyle("-fx-background-color: YELLOW");}
                else{intento9color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento9color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento9color5.setStyle("-fx-background-color: YELLOW");}
                else{intento9color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
            case 10:
                if (booleanosCorrectos.isColor1Correcto()){intento10color1.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor1Existe()){intento10color1.setStyle("-fx-background-color: YELLOW");}
                else{intento10color1.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor2Correcto()){intento10color2.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor2Existe()){intento10color2.setStyle("-fx-background-color: YELLOW");}
                else{intento10color2.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor3Correcto()){intento10color3.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor3Existe()){intento10color3.setStyle("-fx-background-color: YELLOW");}
                else{intento10color3.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor4Correcto()){intento10color4.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor4Existe()){intento10color4.setStyle("-fx-background-color: YELLOW");}
                else{intento10color4.setStyle("-fx-background-color: WHITE");}
                if (booleanosCorrectos.isColor5Correcto()){intento10color5.setStyle("-fx-background-color: GREEN");}
                else if(booleanosExisten.isColor5Existe()){intento10color5.setStyle("-fx-background-color: YELLOW");}
                else{intento10color5.setStyle("-fx-background-color: WHITE");}
                comprobarAcertados(booleanosCorrectos, solucionOculta);
                break;
        }
    }

}