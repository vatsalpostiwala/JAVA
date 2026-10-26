package E27;

import java.lang.*;
import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(4000);
    System.out.println("Server is waiting for connection...");
    Socket s = ss.accept();
    System.out.println("Client connected successfully!");
    
    s.close();
    ss.close();
  }
}