package com.example.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;


public class Receptor implements Runnable {
    JSONArray jsonArray = new JSONArray();
    BufferedReader reader;

    public Receptor(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }


    @Override
    public void run() {
        String read;
        while(true){
            try{
                read = reader.readLine();
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
}