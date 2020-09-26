package com.demo.completableFuture;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class CompletableFuture1 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");
        CompletableFuture.supplyAsync(() -> timeConsumingProcess());

        System.out.println("Program completed ");
    }

    private static int timeConsumingProcess() {
        try {
            Thread.sleep(3000);
        } catch(Exception e) {
            return 1000;
        }
        return 10;
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