package com.demo.completableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JustFuture {

    public static void main(String args[]) throws Exception {
        System.out.println("Program Started");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = createCallable();

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
        System.out.println("Program Started");
    }

    private static Callable<String> createCallable() {
       return () -> {
            // Perform some computation
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };
    }
}
