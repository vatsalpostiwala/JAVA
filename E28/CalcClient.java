package E28;
import java.lang.*;
import java.rmi.*;

public class CalcClient {
    public static void main(String[] args) throws Exception {
        Calculator c = (Calculator) Naming.lookup("rmi://localhost/CalcService");
        System.out.println("10 + 5 = " + c.add(10, 5));
        System.out.println("10 - 5 = " + c.sub(10, 5));
        System.out.println("10 * 5 = " + c.mul(10, 5));
        System.out.println("10 / 4 = " + c.div(10, 4));
    }
}