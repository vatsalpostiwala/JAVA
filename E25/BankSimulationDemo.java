package E25;

import java.lang.*;

class BankAccount {
    int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + "  Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + "  Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class DepositThread extends Thread {
    BankAccount account;

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(200);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {}
        }
    }
}

class WithdrawThread extends Thread {
    BankAccount account;

    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(300);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {}
        }
    }
}

public class BankSimulationDemo {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();
        
        DepositThread dt = new DepositThread(sharedAccount);
        WithdrawThread wt = new WithdrawThread(sharedAccount);
        
        dt.start();
        wt.start();
    }
}