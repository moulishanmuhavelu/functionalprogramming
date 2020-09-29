package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;


/**
 * This is the code sample for exception handling in CompletableFuture.
 * It has 2 paths. normal and exception path.
 */
public class CF6Exceptionally {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");

        CompletableFuture.supplyAsync(() -> methodThrowingNumberFormatException())
                .exceptionally(throwable -> handleException(throwable))
                .thenApply(i -> normalMethod(i))
                .thenAccept(System.out::println);


        System.out.println("Program completed ");
    }

    private static int normalMethod(int value) {
        return 10 * value;
    }

    private static int methodThrowingNumberFormatException() {
        throw new NumberFormatException();
    }

    private static int methodThrowingRuntimeException() {
        throw new RuntimeException();
    }

    private static int handleException(Throwable throwable) {
        System.err.println("Exception handled here:" + throwable.getMessage());
        return 1000;
    }
}

//        CompletableFuture.supplyAsync(() -> methodThrowingNumberFormatException())
//                .exceptionally(throwable -> handleException(throwable))
//                .thenApply(i -> normalMethod(i))
//                .thenApply(t -> methodThrowingRuntimeException())
//                .exceptionally(throwable -> handleException(throwable))
//                .thenAccept(System.out::println);


