package com.demo.completableFuture;

import java.util.concurrent.*;

/**
 * This sample program shows that CompletableFuture is never destroyed
 */
public class CF12NeverDies {

    public static void main(String arg[]) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 2);

        CompletableFuture<Void> voidCompletableFuture = future.thenAccept(System.out::println);

        // Run function will never take any input and not give any output. So the below line is possible
        voidCompletableFuture
                .thenRun(() -> System.out.println("CompletableFuture can never be destroyed"))
                .thenRun(() -> System.out.println("CompletableFuture can never be destroyed. It can keep on going"));


    }
}
