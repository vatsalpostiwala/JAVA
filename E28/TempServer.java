package E28;
import java.lang.*;
import java.rmi.*;
import java.rmi.registry.*;

public class TempServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("TempService", new ConverterImpl());
        System.out.println("Temperature server is ready...");
    }
}