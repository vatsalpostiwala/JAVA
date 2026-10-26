package E28;
import java.lang.*;
import java.rmi.*;

public interface Converter extends Remote {
    double celsiusToFahrenheit(double c) throws RemoteException;
    double fahrenheitToCelsius(double f) throws RemoteException;
}