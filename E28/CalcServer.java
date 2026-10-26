package E28;
import java.lang.*;
import java.rmi.*;
import java.rmi.registry.*;

public class CalcServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("CalcService", new CalculatorImpl());
        System.out.println("Calculator server is ready...");
    }
}