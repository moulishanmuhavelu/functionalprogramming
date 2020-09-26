package com.demo;

import java.util.List;

public class FunctionMethodReferences {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printSquareOfNumbers(numbers);
        System.out.println("-------------------------------------------------------------");
    }

    private static void printSquareOfNumbers(List<Integer> numbers) {
        numbers.stream()
                .map(FunctionMethodReferences :: getSquare)
                .forEach(FunctionMethodReferences :: print);
    }

    private static Integer getSquare(Integer number) {
        return number * number;
    }
    private static void print(Integer number) {
        System.out.println(number);
    }
}