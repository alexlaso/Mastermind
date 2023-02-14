package com.example.mastermind.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorFullDuplex {

    static Socket socket;
    static ServerSocket serverSocket;

    static int port;

        public static void main(String[] args) {
            escuchando();
            aceptandoCliente();
            cabecera();
            recibir();
            enviar();
           // adivinar();
            cerrar();
        }
        private static void cerrar() {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static void recibir() {
            Receptor receptor;

            try {
                receptor = new Receptor(socket.getInputStream(), socket.getOutputStream());
                new Thread(receptor).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            enviar();

        }
    public static void aceptandoCliente(){
        try {
            socket = serverSocket.accept();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error con la conexión del cliente " + e.getMessage());
            return;
        }
    }

        private static void escuchando(){
            port = 4567;
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("No se puede escuchar en el puerto " + port);
                System.exit(0);
            }
        }
        private static void cabecera(){
            System.out.println("Conectando desde: ");
            System.out.println(socket.getLocalAddress() + " : " + socket.getLocalPort());
            System.out.println("a");
            System.out.println(socket.getInetAddress() + ":" + socket.getPort());
        }


    private static void enviar() {
        //PrintWriter out;
        Scanner keyboard;
        try {
            //out = new PrintWriter(socket.getOutputStream());
            keyboard = new Scanner(System.in);
            while(keyboard.hasNext()){
                String line = keyboard.nextLine();
                //out.println(line);
                //out.flush();
                //!out.checkError()&&
            }
        } catch (Exception e) {
            System.out.println("No soy capaz de alcanzar el canal de escritura.");
            System.exit(0);
        }
    }
    }
