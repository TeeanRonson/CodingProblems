package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    final static String EOT = "EOT";

    public static void main(String[] args) {

        System.out.println("Server running");
        //try with resources ensures socket will be closed
        try (
                //open a server socket to listen on port 1024
                ServerSocket server = new ServerSocket(1024);
                //block on accept until a new client connects
                Socket sock = server.accept();
                //wrap the socket input stream in a BufferedReader
                BufferedReader inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()))
        ) {

            //initialize the message
            String message = "";
            //read the first line
            String line = inStream.readLine();

            //keep reading until end of transmission
            while(line != null && !line.trim().equals(EOT)) {
                //append to message
                message += line + "\n";
                //read next line
                line = inStream.readLine();
            }

            //display client message
            System.out.println("Client says: " + message);

            //display client message back to client
            PrintStream ps = new PrintStream(sock.getOutputStream());
            ps.println("Hello, Client, you sent: " + message);
            ps.println("You're welcome, have a good exam!");
            ps.println(EOT);


        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}