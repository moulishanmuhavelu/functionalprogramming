package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;


/**
 * This is the example for combining the results of two CompletableFuture
 */
public class CF8ThenCombine {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");

        makePizzaAsync()
                .thenCombine(buyManyBottlesOfBeerAsync(), (str1, str2) -> str1 + " and " + str2)
                .thenAccept(System.out::println);

        sleep(2000);

        System.out.println("Program completed ");
    }

    private static CompletableFuture<String> makePizzaAsync() {
        return CompletableFuture.supplyAsync(() -> getStatus("Pizza"));
    }

    private static CompletableFuture<String> buyManyBottlesOfBeerAsync() {

        return CompletableFuture.supplyAsync(() -> getStatus("Drinks"));
    }

    private static String getStatus(String task) {

        return task + " Ready";
    }

    private static void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}