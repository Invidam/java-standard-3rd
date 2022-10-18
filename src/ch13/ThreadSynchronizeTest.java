package ch13;

public class ThreadSynchronizeTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new ImportantThread();
        new Thread(r).start();
        new Thread(r).start();
    }

}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return this.balance;
    }
    public synchronized void  withdraw(int money) {
        if(balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            balance -= money;
        }
    }
}

class ImportantThread implements Runnable {
    Account acc = new Account();
    @Override
    public void run() {
        while(acc.getBalance() >0 ){
            int money = ((int) (Math.random() * 3 + 1)) * 100;
            acc.withdraw(money);
            System.out.println("acc.getBalance() = " + acc.getBalance());
        }
    }
}