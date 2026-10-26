package E26;

import java.lang.*;

class SimpleTask implements Runnable {
    String threadName;

    public SimpleTask(String name) {
        threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " is running step " + i);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        SimpleTask task1 = new SimpleTask("Thread A");
        SimpleTask task2 = new SimpleTask("Thread B");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}