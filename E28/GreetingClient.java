package E28;
import java.lang.*;
import java.rmi.*;

public class GreetingClient {
    public static void main(String[] args) throws Exception {
        Greeting g = (Greeting) Naming.lookup("rmi://localhost/GreetingService");
        System.out.println(g.sayHello());
    }
}