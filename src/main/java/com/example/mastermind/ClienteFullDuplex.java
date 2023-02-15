package com.example.mastermind;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteFullDuplex {
    public static void main(String[] args) {

        Socket socket;
        String hostname;
        int port;

        hostname = "localhost";
        try {
            port = 4567;
        }catch (NumberFormatException nfe){
            System.out.println("Introduzca un número de puerto");
            return;
        }

        try{
            socket = new Socket(hostname,port);
        }catch (UnknownHostException uhe){
            System.out.println("No se de que me estas hablando. " + uhe.getMessage());
            return;
        }catch(IOException ioe){
            System.out.println("Error al crear el canal de E/S. " + ioe.getMessage());
            return;
        }

        System.out.println("Conectando desde: ");
        System.out.println(socket.getLocalAddress()+" : "+socket.getLocalPort());
        System.out.println("a");
        System.out.println(socket.getInetAddress() + " : "+socket.getPort());

        Receptor receptor;

        try{
            receptor = new Receptor(socket.getInputStream());
            new Thread(receptor).start();
        } catch (IOException e) {
            System.out.println("No se ha podido alcanzar el canal de lectura.");
            return;
        }

        PrintWriter out;
        try {
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("No se puede obtener el canal de escritura sobre el socket.");
            try{
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }return;
        }

        /*Scanner keyboard = new Scanner(System.in);
        while (!out.checkError() && keyboard.hasNextLine()){
            String line = keyboard.nextLine();
            out.println(line);
            out.flush();
        }
        try{
            out.close();
            socket.close();
            keyboard.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
