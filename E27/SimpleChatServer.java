package E27;

import java.lang.*;
import java.io.*;
import java.net.*;

public class SimpleChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        System.out.println("Server waiting for connection...");
        Socket s = ss.accept();
        System.out.println("Client connected! Type 'exit' to stop.");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String clientMsg = in.readLine();
            if (clientMsg == null || clientMsg.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Client: " + clientMsg);
            
            System.out.print("Server (You): ");
            String serverMsg = kb.readLine();
            out.println(serverMsg);
            if (serverMsg.equalsIgnoreCase("exit")) {
                break;
            }
        }
        
        s.close();
        ss.close();
    }
}