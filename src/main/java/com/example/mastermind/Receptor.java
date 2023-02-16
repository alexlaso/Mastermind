package com.example.mastermind;

import java.io.*;

import com.example.mastermind.entity.BooleanosCorrectos;
import com.example.mastermind.entity.BooleanosExisten;
import com.example.mastermind.entity.Codigo;
import com.google.gson.Gson;



public class Receptor implements Runnable {
    DataInputStream reader;
    String read;
    BooleanosExisten booleanosExisten = new BooleanosExisten();
    BooleanosCorrectos booleanosCorrectos= new BooleanosCorrectos();
    Codigo solucionOculta = new Codigo();
    HelloController helloController;

    public Receptor(InputStream inputStream, HelloController helloController){
        reader = new DataInputStream(inputStream);
        this.helloController = helloController;
    }


    @Override
    public void run() {
        while(true){
            try{
                read = reader.readUTF();
                pintorAleman();
            } catch (IOException e) {
                System.out.println("No soy capaz de leer.");
                break;
            }
            if (read==null){
                //EOF
                break;
            }
            if (read.equals("exit")){
                System.exit(0);
            }
            System.out.println(read);
        }
    }

    public void pintorAleman() throws IOException {
        Gson gson = new Gson();
        switch(read){
            case"ocultacion":
                solucionOculta = gson.fromJson(reader.readUTF(), Codigo.class);
                //Félix no me mates, necesito que el cliente obtenga la solución para pintarlo en caso de que lo acierte...
                break;
            case"blitzkrieg":
                booleanosCorrectos = gson.fromJson(reader.readUTF(),BooleanosCorrectos.class);
                System.out.println(booleanosCorrectos.toString());
                booleanosExisten = gson.fromJson(reader.readUTF(),BooleanosExisten.class);
                System.out.println(booleanosExisten.toString());
                helloController.arte(booleanosCorrectos, booleanosExisten, solucionOculta);
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

}