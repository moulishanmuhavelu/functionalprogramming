package com.demo;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesSampleTwo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15, 24, 35, 19, 6, 24, 33);

        BinaryOperator<Integer> sumTwoNumbersWithBinaryOperator = (x, y) -> x + y;
        UnaryOperator<Integer> multiplyByTwoUnaryOperator = (x) -> x * 2;
        Supplier<Integer> randomNumberSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        numbers.stream()
                .map( x -> sumTwoNumbersWithBinaryOperator.apply(x, 10))
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        numbers.stream()
                .map(multiplyByTwoUnaryOperator)
                .forEach(e -> System.out.println(e + ":" + randomNumberSupplier.get()));
        System.out.println("------------------------------------------------------------------------");

    }

}