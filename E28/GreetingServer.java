package E28;
import java.lang.*;
import java.rmi.*;
import java.rmi.registry.*;

public class GreetingServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("GreetingService", new GreetingImpl());
        System.out.println("Server is ready...");
    }
}