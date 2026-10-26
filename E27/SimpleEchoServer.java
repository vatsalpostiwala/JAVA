package E27;

import java.lang.*;
import java.io.*;
import java.net.*;

public class SimpleEchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Echo Server is running...");
        Socket s = ss.accept();
        System.out.println("Client connected!");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        
        String msg;
        while ((msg = in.readLine()) != null) {
            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Received: " + msg);
            out.println("Server Echo: " + msg); 
        }
        
        s.close();
        ss.close();
    }
}