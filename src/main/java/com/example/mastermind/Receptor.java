package com.example.mastermind;

import java.io.*;

import com.example.mastermind.entity.BooleanosCorrectos;
import com.example.mastermind.entity.BooleanosExisten;
import com.google.gson.Gson;



public class Receptor implements Runnable {
    DataInputStream reader;
    String read;
    BooleanosExisten booleanosExisten;
    BooleanosCorrectos booleanosCorrectos;
    HelloController helloController;

    public Receptor(InputStream inputStream, HelloController helloController){
        reader = new DataInputStream(inputStream);
        this.helloController = helloController;
    }


    @Override
    public void run() {
        while(true){
            try{
                read = reader.readLine();
                pintorAleman(booleanosCorrectos, booleanosExisten);
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

    public void pintorAleman(BooleanosCorrectos booleanosCorrectos, BooleanosExisten booleanosExisten) throws IOException {
        switch(read){
            case"blitzkrieg":
                objetosParaPintar(booleanosCorrectos, booleanosExisten);
                //arte(booleanosCorrectos, booleanosExisten);
        }
    }

    private void objetosParaPintar(BooleanosCorrectos booleanosCorrectos, BooleanosExisten booleanosExisten) throws IOException {
        Gson gson = new Gson();

        String jsoncorrectos = reader.readUTF();
        booleanosCorrectos = gson.fromJson(jsoncorrectos,BooleanosCorrectos.class);

        String jsonexisten = reader.readUTF();
        booleanosExisten = gson.fromJson(jsonexisten,BooleanosExisten.class);

        helloController.arte(booleanosCorrectos, booleanosExisten);
        System.out.println("hola holita");
        System.out.println(booleanosCorrectos.toString());
        System.out.println(booleanosExisten.toString());
    }
}