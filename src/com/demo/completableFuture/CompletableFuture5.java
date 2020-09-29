package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;


/**
 * This program shows how we can build the pipeline separately and call them as we need it.
 */
public class CompletableFuture5 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");
        System.out.println("main Thread=" + Thread.currentThread());

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        process(completableFuture);
        completableFuture.complete(7);
        System.out.println("Program completed ");
    }

    //This is the pipeline of the CompletableFuture
    private static void process(CompletableFuture<Integer> completableFuture) {
        completableFuture.thenApply(e -> e * 5)
                .thenApply(p -> p + 20)
                .thenAccept(System.out::println);

    }

    //This is another pipeline of the CompletableFuture
    private static void process2(CompletableFuture<Integer> completableFuture) {
        completableFuture.thenApply(e -> e * 10)
                .thenApply(p -> p + 50)
                .thenApply(y -> y *100)
                .thenAccept(System.out::println);

    }

}












/*
    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");
        CompletableFuture.supplyAsync(() -> timeConsumingProcess()).thenAccept(System.out::println);

        System.out.println("Main thread sleeps for 5 seconds");
        Thread.sleep(5000);

        System.out.println("Program completed ");
    }
*/
