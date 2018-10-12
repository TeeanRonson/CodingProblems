package Sockets;

import sun.plugin2.message.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleClient {
    final static int PORT = 1024;
    final static String EOT = "EOT";


    public static void main(String[] args) {

        System.out.println("Client running");
        //try with resources ensures socket will be closed
        try (
                //open a socket to host: localhost port: PORT
                Socket s = new Socket(InetAddress.getLocalHost(), PORT);

                InputStreamReader is = new InputStreamReader(s.getInputStream());
                BufferedReader inStream = new BufferedReader(is);

                //wrap the socket output stream in a PrintWriter that will autoFlush
                PrintStream out = new PrintStream(s.getOutputStream(), true)

        ) {

            //print a message
            out.println("Hello server, thanks for connecting on this demo");
            //print the end of transmission token
            out.println("EOT");


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

            System.out.println("We received a reply from the server:");
            System.out.println(message);

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}