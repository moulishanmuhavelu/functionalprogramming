package com.demo.completableFuture;

public class NoCompletableFuture {

    public static void main(String arg[]) {

        System.out.println("Program Started ");
        int value = timeConsumingProcess(); // Main thread is blocked during this call
        System.out.println("value = " + value);
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
