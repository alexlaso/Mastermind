package com.example.mastermind;

import com.example.mastermind.servidor.ServidorFullDuplex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    /* Agradecimiento especiales:
     diMITRI
     github.com/dimo-tastik
     xFoqus (Iván Romero Haut)
     github.com/xFoqus
     */


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 700);
        stage.setTitle("Mastermind");
        stage.setScene(scene);
        stage.show();

        Popup popup = new Popup();
        popup.sizeToScene();
        String texto = "INSTRUCCIONES \n- Introduce un color en cada selector debajo.\n- Haz click en enviar para validar tu intento.\n- Posición y color acertados = verde.\n- Color acertado = amarillo.\n- Fallo = blanco.\n- Tienes 10 intentos, BUENA SUERTE.\n- IMPORTANTE, LOS COLORES PUEDEN REPETIRSE\n- Haz click para ocultar este mensaje.";
        Label label = new Label(texto);
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-background-color: #202020");
        popup.getContent().add(label);
        popup.show(stage);
        popup.setAutoHide(true);
    }

    public static void main(String[] args) {
        //ClienteFullDuplex cliente = new ClienteFullDuplex();
        //cliente.main(args);
        launch();
    }
}