package com.example.mastermind;

import java.io.*;

import com.google.gson.Gson;



public class Receptor implements Runnable {
    BufferedReader reader;
    String read;
    BooleanosExisten booleanosExisten;
    BooleanosCorrectos booleanosCorrectos;

    public Receptor(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
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

    private static void objetosParaPintar(BooleanosCorrectos booleanosCorrectos, BooleanosExisten booleanosExisten) throws IOException {
        String jsoncorrectos = "";
        String jsonexisten = "";

        BufferedReader brCorr = new BufferedReader(new FileReader("src/resources/correctos.json"));
        BufferedReader brEx = new BufferedReader(new FileReader("src/resources/existen.json"));

        String lineaSol = "";
        String lineaInt = "";

        while ((lineaSol = brCorr.readLine()) != null){
            jsoncorrectos+=lineaSol;
        }
        while ((lineaInt = brEx.readLine()) != null){
            jsonexisten+=lineaInt;
        }

        Gson gson = new Gson();
        booleanosCorrectos = gson.fromJson(jsoncorrectos,BooleanosCorrectos.class);
        booleanosExisten = gson.fromJson(jsonexisten,BooleanosExisten.class);
    }

}