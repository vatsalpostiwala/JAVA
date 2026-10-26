package E28;
import java.lang.*;
import java.rmi.*;

public interface Greeting extends Remote {
    String sayHello() throws RemoteException;
}