package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * This sample program shows the difference between thenApply and thenCompose
 * thenApply is same as map() function in Streams and thenCompose is same as flatMap() in Streams
 */
public class CompletableFuture10 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");

        CompletableFuture<CompletableFuture<String>> thenApplyCF = CompletableFuture.supplyAsync(()->{
            return "Microsoft";
        }).thenApply(value-> {
            return CompletableFuture.completedFuture(value.toUpperCase());
        });
        System.out.println("Value - " + thenApplyCF.get().get()); // Notice that we get a CompletableFuture inside another one

        CompletableFuture<String>  thenComposeCF = CompletableFuture.supplyAsync(()->{
            return "Amazon";
        }).thenCompose(value-> {
            return CompletableFuture.completedFuture(value.toUpperCase());
        });

        System.out.println("Value - " + thenComposeCF.get()); // Notice that we directly get the result

        sleep(4000);

        System.out.println("Program completed ");
    }



    private static void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}