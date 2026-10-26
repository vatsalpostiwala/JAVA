package E28;
import java.lang.*;
import java.rmi.*;
import java.util.Scanner;

public class TempClient {
    public static void main(String[] args) throws Exception {
        Converter c = (Converter) Naming.lookup("rmi://localhost/TempService");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter temperature in Celsius: ");
        double cel = sc.nextDouble();
        System.out.println("In Fahrenheit: " + c.celsiusToFahrenheit(cel));
        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fah = sc.nextDouble();
        System.out.println("In Celsius: " + c.fahrenheitToCelsius(fah));
    }
}