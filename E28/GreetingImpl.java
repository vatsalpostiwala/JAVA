package E28;
import java.lang.*;
import java.rmi.*;
import java.rmi.server.*;

public class GreetingImpl extends UnicastRemoteObject implements Greeting {
    public GreetingImpl() throws RemoteException {
        super();
    }
    public String sayHello() {
        return "Hello from the RMI Server!";
    }
}