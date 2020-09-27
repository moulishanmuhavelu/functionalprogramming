package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This sample program shows how CompletableFuture uses ExecutorService
 */
public class CompletableFuture11 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        makePizzaAsync(executorService)
                .thenApplyAsync(s->buyDrinksAsync(s, executorService))
                .thenAccept(System.out::println);

        sleep(4000);

        System.out.println("Thread in main -" + Thread.currentThread());
        System.out.println("Program completed ");
    }

    private static CompletableFuture<String> makePizzaAsync(ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println("Thread in makePizzaAsync-" + Thread.currentThread());
            return "Pizza ready";
        }, executorService);
    }

    private static String buyDrinksAsync(String previousStatus, ExecutorService executorService) {
        System.out.println("Thread in buyDrinksAsync-" + Thread.currentThread());
        return previousStatus + " and " + "Drinks ready";
    }

    private static void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}