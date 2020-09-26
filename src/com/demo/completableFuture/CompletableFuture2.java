package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * This program shows the implementation of Runnable interface
 */
public class CompletableFuture2 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");
        CompletableFuture.runAsync(CompletableFuture2::sendMailToEmployees);

        System.out.println("Main thread sleeps for 5 seconds");
        Thread.sleep(5000);

        System.out.println("Program completed ");
    }

    private static void sendMailToEmployees() {
        try {
            Thread.sleep(3000);
            System.out.println("Mail sent to all Cognizant employees");
        } catch(Exception e) {
            e.printStackTrace();
        }
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
