package E27;

import java.lang.*;
import java.io.*;
import java.net.*;

public class SimpleChatClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6000);
        System.out.println("Connected to server! Type 'exit' to stop.");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            System.out.print("Client (You): ");
            String clientMsg = kb.readLine();
            out.println(clientMsg);
            if (clientMsg.equalsIgnoreCase("exit")) {
                break;
            }
            
            String serverMsg = in.readLine();
            if (serverMsg == null || serverMsg.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Server: " + serverMsg);
        }
        
        s.close();
    }
}