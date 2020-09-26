package com.demo;

import java.util.List;

public class SampleOneFunctional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printAllNumbersInListStructured(numbers);
        System.out.println("-------------------------------------------------------------");
        printEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        numbers.forEach(System.out::println);

//        numbers.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        numbers.stream().filter(mouli -> mouli % 2 == 0).forEach(System.out::println);
    }
}