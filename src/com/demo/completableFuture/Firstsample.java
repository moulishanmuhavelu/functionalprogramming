package com.demo.completableFuture;

import java.util.concurrent.*;


public class Firstsample {

    public static CompletableFuture<Integer> create() {
        return (CompletableFuture.supplyAsync(() -> 2));
    }

    public static void main(String arg[]) {
        CompletableFuture<Integer> future = create();

        future.thenAccept(System.out::println); // This line will return CompletableFuture<Void>

        CompletableFuture<Void> voidCompletableFuture = future.thenAccept(System.out::println);

        // Run function will never take any input and not give any output. So the below line is possible
        voidCompletableFuture
                .thenRun(() -> System.out.println("CompletableFuture can never be destroyed"))
                .thenRun(() -> System.out.println("CompletableFuture can never be destroyed. It can keep on going"));


    }
}
