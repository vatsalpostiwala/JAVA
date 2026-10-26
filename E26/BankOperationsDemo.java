package E26;

import java.lang.*;

class DepositTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Depositing Rs. 1000 (Transaction " + i + ")");
        }
    }
}

class WithdrawalTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Withdrawing Rs. 500 (Transaction " + i + ")");
        }
    }
}

public class BankOperationsDemo {
    public static void main(String[] args) {
        Thread depositThread = new Thread(new DepositTask());
        Thread withdrawalThread = new Thread(new WithdrawalTask());
        
        depositThread.start();
        withdrawalThread.start();
    }
}