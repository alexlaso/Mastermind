package com.example.mastermind.servidor;

import com.example.mastermind.Codigo;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receptor implements Runnable {
    List<String> colores = new ArrayList<String>();

    BufferedReader reader;
    PrintWriter writer;
    String read;
    int intentos = 0, min = 0, max = 100, prueba = 0;

    public Receptor(InputStream inputStream, OutputStream outputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
        writer = new PrintWriter(outputStream);

        colores.add("BLACK");
        colores.add("BLUE");
        colores.add("WHITE");
        colores.add("GREEN");
        colores.add("RED");
        colores.add("YELLOW");
        colores.add("PINK");
        colores.add("PURPLE");
        generarSolucion("solucion.json");
    }


    @Override
    public void run() {
        while(true){
            try{read = reader.readLine();
                adivinar();
                writer.flush();
            } catch (IOException e) {
                System.out.println("No soy capaz de leer.");
                break;
            }
            if (read==null){
                //EOF
                break;
            }
            System.out.println(read);
        }
    }


    private void adivinar() {
        }
private void generarSolucion(String filename){
    Codigo solucion = new Codigo();
    List<String> elegidos = new ArrayList<String>();
    for (int i=0; i<5;i++){
        Collections.shuffle(colores);
        elegidos.add(colores.get(0));
    }
    JSONObject json = new JSONObject();
    solucion.setColor1(elegidos.get(0));
    json.put("color1", solucion.getColor1());

    solucion.setColor2(elegidos.get(1));
    json.put("color2", solucion.getColor2());

    solucion.setColor3(elegidos.get(2));
    json.put("color3", solucion.getColor3());

    solucion.setColor4(elegidos.get(3));
    json.put("color4", solucion.getColor4());

    solucion.setColor5(elegidos.get(4));
    json.put("color5", solucion.getColor5());

    File f = new File("solucion.json");
    try {
        f.createNewFile();
        System.out.println("Fichero creado exitosamente");
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter(f));
        bw.write(json.toString());
        System.out.println("Fichero escrito exitosamente");
        bw.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("Solucion generada mi señor");
    }

}


