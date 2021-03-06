package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * This is the example for passing the result of one CompletableFuture to the other
 */
public class CF9AThenCompose {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");

        // If getPassportAsync() returned a String we could have just used thenApply() method.
        // but it returns a CompletableFuture<CompletableFuture<String>>. So for this we need to use thenCombine only
        getPassportAsync()
                .thenCompose((passportStatus) -> getVisaAsync(passportStatus))
                .thenAccept(System.out::println);

        sleep(2000);

        System.out.println("Program completed ");
    }

    private static CompletableFuture<String> getPassportAsync() {
        return CompletableFuture.supplyAsync(() -> getStatus("Passport"));
    }

    private static CompletableFuture<String> getVisaAsync(String passportStatus) {

        return CompletableFuture.supplyAsync(() -> passportStatus + " and " + getStatus("Visa"));
    }

    private static String getStatus(String task) {

        return task + " Ready";
    }

    private static void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}