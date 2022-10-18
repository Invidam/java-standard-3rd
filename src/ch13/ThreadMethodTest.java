package ch13;

import javax.swing.JOptionPane;

public class ThreadMethodTest {

    public static void main(String[] args) throws InterruptedException {
//        sleepTest();

        Thread3 t1 = new Thread3();
        t1.start();
        JOptionPane.showInputDialog("입력");
        t1.interrupt();
        System.out.println("thread1 = " + t1.isInterrupted());
    }

    private static void sleepTest() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
}
class Thread1 extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("|");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        System.out.println("TH1 종료");
    }
}
class Thread2 extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("-");
        }
        System.out.println("TH2 종료");
    }
}
class Thread3 extends Thread {

    public void run() {
        while (!interrupted()) {
            System.out.printf("=");
        }
        System.out.println("TH3 종료");
    }
}