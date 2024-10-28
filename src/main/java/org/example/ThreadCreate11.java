package org.example;

import java.util.concurrent.*;

public class ThreadCreate11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 42;
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("Future done ? " + future.isDone());

        Integer result = future.get(); // İşlemin tamamlanması için beklenir

        System.out.println("Future done ? " + future.isDone());
        System.out.println("Result: " + result);
        executor.shutdown();
    }
}
