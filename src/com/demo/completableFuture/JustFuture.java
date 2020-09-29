package com.demo.completableFuture;

import java.util.concurrent.*;

public class JustFuture {

    public static void main(String args[]) throws Exception {
        System.out.println("Program Started");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callableTask = timeConsumingTask();

        System.out.println("Submitting Callable--thread-->" + Thread.currentThread());
        Future<String> future = executorService.submit(callableTask);
        Thread.sleep(4000);// We are sleeping to show that the timeConsumingTask is executed in a separate thread
        // This line executes immediately
        System.out.println("Do something else while task is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
        System.out.println("Program Completed");

    }

    private static Callable<String> timeConsumingTask() {
       return () -> {
            // Perform some computation
            System.out.println("Entered Time Consuming Task--thread-->" + Thread.currentThread());
            Thread.sleep(2000);
            return "Hello from Time Consuming Task";
        };
    }
}
