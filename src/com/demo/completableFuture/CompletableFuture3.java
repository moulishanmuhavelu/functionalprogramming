package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;


/**
 * Proves that CompletableFuture is run in a separate thread by printing the thread ids
 */
public class CompletableFuture3 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");
        System.out.println("main Thread=" + Thread.currentThread());

        CompletableFuture.runAsync(CompletableFuture3::sendMailToEmployees);
        Thread.sleep(5000);

        System.out.println("Program completed ");
    }

    private static void sendMailToEmployees() {
        try {
            Thread.sleep(3000);
            System.out.println("sendMailToEmployees Thread=" + Thread.currentThread());
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
