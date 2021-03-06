package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a very poorly designed HTTP server able to reply to one request with a static HTML page.
 * @author srollins
 *
 */
public class HTTPServer {

    public static void main(String[] args) {

        try (ServerSocket serve = new ServerSocket(1024);
             Socket sock = serve.accept();
             BufferedReader instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             PrintWriter writer = new PrintWriter(sock.getOutputStream())) {

            String body = "";
            String request = instream.readLine();

            String line = instream.readLine();
            while(line != null && !line.trim().isEmpty()) {
                body += line + "\n";
                line = instream.readLine();
            }

            System.out.println("Request Line: \n" + request);
            System.out.println("Body \n" + body);

            String[] requestParts = request.split("\\s+");

//            String headers = "HTTP/1.0 200 OK\n" +
//                    "\r\n";

            String page = "<html> " +
                    "<head><title>TEST</title></head>" +
                    "<body>This is a short test page.</body>" +
                    "</html>";

            writer.write(body);
            writer.write(page);
            writer.flush();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}