package com.example.mastermind.servidor;

import com.example.mastermind.entity.Codigo;
import com.example.mastermind.entity.Verificador;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receptor implements Runnable {
    List<String> colores = new ArrayList<String>();

    DataInputStream reader;
    DataOutputStream writer;
    String read;
    Codigo solucion = new Codigo();
    Codigo intento= new Codigo();
    JSONObject json = new JSONObject();
    public Receptor(InputStream inputStream, OutputStream outputStream){
        reader = new DataInputStream(inputStream);
        writer = new DataOutputStream(outputStream);

        colores.add("BLACK");
        colores.add("BLUE");
        colores.add("WHITE");
        colores.add("GREEN");
        colores.add("RED");
        colores.add("YELLOW");
        colores.add("PINK");
        colores.add("PURPLE");
    }


    @Override
    public void run() {
        generarSolucion();
        while(true){
            try {
                writer.writeUTF("ocultacion");
                writer.writeUTF(json.toString());
                read = reader.readUTF();
                logica();
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (read==null){
                //EOF
                break;
            }
            System.out.println(read);
        }
    }


    public void logica() {
        Verificador verificador = new Verificador();
        Gson gson = new Gson();
        switch (read){
            case "comprueba":
                try {
                    intento = gson.fromJson(reader.readUTF(),Codigo.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                verificador.comprobarPosiciones(solucion, intento);

                JSONObject jsonCorrectos = new JSONObject().put("color1Correcto",verificador.isColor1Correcto()).put("color2Correcto",verificador.isColor2Correcto()).put("color3Correcto",verificador.isColor3Correcto()).put("color4Correcto",verificador.isColor4Correcto()).put("color5Correcto",verificador.isColor5Correcto());


                verificador.comprobarExistencia(solucion, intento);
                JSONObject jsonExisten = new JSONObject().put("color1Existe",verificador.isColor1Existe()).put("color2Existe",verificador.isColor2Existe()).put("color3Existe",verificador.isColor3Existe()).put("color4Existe",verificador.isColor4Existe()).put("color5Existe",verificador.isColor5Existe());

                try {
                    writer.writeUTF("blitzkrieg");

                    writer.writeUTF(jsonCorrectos.toString());
                    writer.flush();

                    writer.writeUTF(jsonExisten.toString());
                    writer.flush();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    writer.writeUTF("Error desconocido");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
private void generarSolucion(){

    List<String> elegidos = new ArrayList<String>();
    for (int i=0; i<5;i++){
        Collections.shuffle(colores);
        elegidos.add(colores.get(0));
    }
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

    System.out.println("Solución: "+json.toString());
    }
}