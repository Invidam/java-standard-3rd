package ch13;

import javax.swing.JOptionPane;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
//        baseTest();
//        singleThreadIO();
//        multiThreadIO();
        Thread thread = new Thread(new DaemonThread());
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            if(i % 5 == 0) DaemonThread.autoSave = true;
        }
    }

    private static void singleThreadIO() throws InterruptedException {
        String inputDialog = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println(inputDialog);
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            Thread.sleep(1000);
        }
    }

    private static void multiThreadIO() throws InterruptedException {
        ThreadFromThread t1 = new ThreadFromThread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i = " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        String inputDialog = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println(inputDialog);
    }

    private static void baseTest() {
        Thread t1 = new ThreadFromThread();
        Runnable runnable = new ThreadFromRunnable();
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}

class ThreadExample extends Thread {

    public void run() {
        System.out.println("ThreadExample.run");
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadFromThread extends Thread {

    public void run() {
    }
}

class ThreadFromRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


class DaemonThread implements Runnable {
    static boolean autoSave = false;
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (autoSave) {
                System.out.println("Auto saved.");
            }
        }
    }
}