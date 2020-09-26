package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuture7 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");

        CompletableFuture.supplyAsync(() -> getPerformanceRatingFromManager())
                .completeOnTimeout("Exceeded All", 2, TimeUnit.MILLISECONDS)
                .thenAccept(System.out::println);

//        CompletableFuture.supplyAsync(() -> getPerformanceRatingFromManager())
//                .completeOnTimeout(getPerformanceRatingFromAPeer(), 2, TimeUnit.MILLISECONDS)
//                .thenAccept(System.out::println);

        // Just timeout and not returning a default value
//        CompletableFuture.supplyAsync(() -> getPerformanceRatingFromManager())
//                .orTimeout(2, TimeUnit.MILLISECONDS)
//                .thenAccept(System.out::println).join();


        sleep(5);

        System.out.println("Program completed ");
    }

    private static String getPerformanceRatingFromManager() {
        sleep(8);
        return "Exceeded Most";
    }

    private static String getPerformanceRatingFromAPeer() {
        return "Met All";
    }

    private static void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}