package org.example;

public class ThreadCreate3 {
    public static void main(String[] args) {
        ReusableTask reusableTask = new ReusableTask();

        Thread thread1 = new Thread(reusableTask);
        thread1.start();

        Thread thread2 = new Thread(reusableTask);
        thread2.start();
    }
}

class ReusableTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Reusable Task: " + i);
        }
    }
}
