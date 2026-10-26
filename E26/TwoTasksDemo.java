package E26;

import java.lang.*;

class TaskOne implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task 1 is running: " + i);
        }
    }
}

class TaskTwo implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task 2 is running: " + i);
        }
    }
}

public class TwoTasksDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TaskOne());
        Thread t2 = new Thread(new TaskTwo());
        
        t1.start();
        t2.start();
    }
}