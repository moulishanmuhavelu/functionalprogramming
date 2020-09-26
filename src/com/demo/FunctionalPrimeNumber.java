package com.demo;

import java.util.stream.IntStream;

public class FunctionalPrimeNumber {

    public static void main(String[] args) {

        boolean isPrime = isPrimeFunctional(7);
        System.out.println(isPrime);

    }

    private static boolean isPrimeFunctional(int number) {
        return number > 1
                && IntStream.range(2 , number)
                            .noneMatch(currentNumber -> number % currentNumber == 0);
    }

    private static boolean isPrimeStructural(int number) {
        boolean divisible = false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }
        return divisible;
    }
}