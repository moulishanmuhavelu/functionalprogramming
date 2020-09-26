package com.demo.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture4 {

    public static void main(String arg[]) throws Exception {

        System.out.println("Program Started ");
        System.out.println("main Thread=" + Thread.currentThread());

        CompletableFuture.supplyAsync(() -> getEmployeeGrossSalary())
            .thenApply((salary) -> deductTax(salary))
                .thenApply((salary) -> deductInsurance(salary))
        .thenAccept(System.out::println);
        Thread.sleep(5000);

        System.out.println("Program completed ");
    }

    private static int getEmployeeGrossSalary() {
        try {
            Thread.sleep(2000);
            System.out.println("getEmployeeGrossSalary Thread=" + Thread.currentThread());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 10000;
    }

    private static int deductTax(int salary) {
        System.out.println("deductTax Thread=" + Thread.currentThread());
        return (salary - 2000);
    }

    private static int deductInsurance(int salary) {
        System.out.println("deductInsurance Thread=" + Thread.currentThread());
        return (salary - 200);
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
