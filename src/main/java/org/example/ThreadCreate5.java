package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreate5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 3; i++) {
            Runnable taskInPool = new TaskInThreadPool();
            executorService.execute(taskInPool);
        }
        executorService.shutdown();
    }
}

class TaskInThreadPool implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
