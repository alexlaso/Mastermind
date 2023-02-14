package com.example.mastermind.servidor;

import java.io.*;

public class Receptor implements Runnable {

    BufferedReader reader;
    PrintWriter writer;
    String read;
    int intentos = 0, min = 0, max = 100, prueba = 0;

    public Receptor(InputStream inputStream, OutputStream outputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
        writer = new PrintWriter(outputStream);
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
        if (intentos == 0){
            generador(min, max, prueba);
            writer.println("Algo me dice que estás pensando en el número: "+prueba);
            writer.println("¿Es tu número?");
            intentos+=1;
        }else if (intentos>0){
            switch (read){
                case "Si","si":
                    writer.println("Y solo me ha llevado "+intentos+" intentos acertarlo");
                    intentos=-1;
                    break;
                case "No", "no":
                    writer.println("¿Tu número es mayor o menor?");
                    writer.flush();
                    try {
                        read =reader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    switch (read) {
                        case "Mayor", "mayor":
                            min = prueba;
                            writer.println("¿Quizá es este?");
                            writer.println(prueba);
                            intentos += 1;
                            generador(min, max, prueba);
                            break;
                        case "Menor", "menor":
                            max = prueba;
                            writer.println("¿Quizá es este?");
                            writer.println(prueba);
                            intentos += 1;
                            generador(min, max, prueba);
                            break;
                        case "exit":
                            writer.println("exit");
                            writer.flush();
                            System.exit(0);
                            break;
                        default:
                            writer.println("Te has colado crack");
                            break;
                    }break;
                    case "exit":
                        writer.println("exit");
                        writer.flush();
                        System.exit(0);
                }
            }
        else if(intentos == -1){
            writer.println("¿Quieres jugar de nuevo?");
            try {
                read = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch(read){
                case "Si", "si":
                    intentos =0;
                    break;
                case "No", "no":
                    writer.println("exit");
                    writer.flush();
                    System.exit(0);
            }
        }
    }
    private void generador(int min, int max, int prueba){
       this.prueba = (int) (Math.random() * (max - min) + min);
    }}

