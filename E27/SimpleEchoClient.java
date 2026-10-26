package E27;

import java.lang.*;
import java.io.*;
import java.net.*;

public class SimpleEchoClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        System.out.println("Connected to server! Type 'exit' to stop.");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        
        String msg;
        while (true) {
            System.out.print("Enter message: ");
            msg = kb.readLine();
            out.println(msg);
            
            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
            
            System.out.println(in.readLine());
        }
        
        s.close();
    }
}