package com.example.mastermind.servidor;

import com.example.mastermind.Codigo;
import com.example.mastermind.Verificador;
import com.google.gson.Gson;
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
        generarSolucion("resources/solucion.json");
    }


    @Override
    public void run() {
        Codigo solucion = new Codigo();
        Codigo intento = new Codigo();
        while(true){
            try{read = reader.readLine();
                logica(solucion, intento);
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


    private void logica(Codigo solucion, Codigo intento) {
        Verificador verificador = new Verificador();
        try {
            generarObjetos(solucion, intento);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch (read){
            case "comprueba": verificador.comprobarExistencia(solucion, intento);
            verificador.comprobarPosiciones(solucion, intento);
            ajustarRespuesta(verificador);
            writer.println("blitzkrieg");
            break;
        }
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

    File f = new File("src/resources/solucion.json");
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

    public void generarObjetos(Codigo solucion, Codigo intento) throws IOException {
        String jsonsolucion = "";
        String jsonintento = "";

        BufferedReader brSol = new BufferedReader(new FileReader("src/resources/solucion.json"));
        BufferedReader brInt = new BufferedReader(new FileReader("src/resources/intento.json"));

        String lineaSol = "";
        String lineaInt = "";

        while ((lineaSol = brSol.readLine()) != null){
            jsonsolucion+=lineaSol;
        }
        while ((lineaInt = brInt.readLine()) != null){
            jsonintento+=lineaInt;
        }

        Gson gson = new Gson();
        solucion = gson.fromJson(jsonsolucion,Codigo.class);
        intento = gson.fromJson(jsonintento,Codigo.class);
    }

    public void ajustarRespuesta(Verificador verificador){
        JSONObject jsonCorrecto = new JSONObject().put("color1Correcto", verificador.isColor1Correcto()).put("color2Correcto", verificador.isColor2Correcto()).put("color3Correcto", verificador.isColor3Correcto()).put("color4Correcto", verificador.isColor4Correcto()).put("color5Correcto", verificador.isColor5Correcto());

        JSONObject jsonExisten = new JSONObject().put("color1Existe", verificador.isColor1Existe()).put("color2Existe", verificador.isColor2Existe()).put("color3Existe", verificador.isColor3Existe()).put("color4Existe", verificador.isColor4Existe()).put("color5Existe", verificador.isColor5Existe());

        File f = new File("src/resources/correctos.json");
        try {
            f.createNewFile();
            System.out.println("Correctos creado exitosamente");
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(f));
            bw.write(jsonCorrecto.toString());
            System.out.println("Correctos escrito exitosamente");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File fAux = new File("src/resources/existen.json");
        try {
            fAux.createNewFile();
            System.out.println("Existen creado exitosamente");
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(fAux));
            bw.write(jsonExisten.toString());
            System.out.println("Existen escrito exitosamente");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}