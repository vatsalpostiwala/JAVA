package E25;

import java.lang.*;

class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}

public class PrintNumbersDemo {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        NumberThread t2 = new NumberThread();
        
        t1.start();
        t2.start();
    }
}