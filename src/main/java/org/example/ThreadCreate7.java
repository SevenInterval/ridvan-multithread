package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCreate7 {
    private int count = 10;
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadCreate7 counter = new ThreadCreate7();

        Runnable task = counter::increment;

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();
    }

    public void increment() {
        lock.lock(); // Kilitleme işlemi yapılır
        try {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + " Count: " + --count);
            }
        } finally {
            lock.unlock(); // Kilit serbest bırakır
        }
    }
}
