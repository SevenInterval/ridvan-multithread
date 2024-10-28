package org.example;

public class ThreadCreate4 {
    public static void main(String[] args) {
        SharedResourceTask task = new SharedResourceTask();

        Thread thread = new Thread(task);
        thread.start();

        Thread thread2 = new Thread(task);
        thread2.start();
    }
}

class SharedResourceTask implements Runnable {
    private int sharedValue = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + ++sharedValue);
        }
    }
}
