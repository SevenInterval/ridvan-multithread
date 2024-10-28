package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreate10 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " asynchronous task");
            }
        });
        executor.shutdown();
    }
}
