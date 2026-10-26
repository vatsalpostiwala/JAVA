package E25;

import java.lang.*;

class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        
        System.out.println("State of t1 before start: " + t1.getState());
        
        t1.start();
        t2.start();
        
        System.out.println("State of t1 after start: " + t1.getState());
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("State of t1 after finish: " + t1.getState());
    }
}