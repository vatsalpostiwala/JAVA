package E27;

import java.lang.*;
import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws Exception {
    Socket s = new Socket("localhost", 4000);
    System.out.println("Connected to the server successfully!");
    
    s.close();
  }
}