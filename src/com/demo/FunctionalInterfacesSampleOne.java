package com.demo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesSampleOne {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15, 24, 35, 19, 6, 24, 33);

        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Function<Integer, Integer> squareNumberFunction = x -> x * x;
        Consumer<Integer> printConsumer = System.out::println;

        numbers.stream()
                .filter(evenPredicate)
                .map(squareNumberFunction)
                .forEach(printConsumer);
    }

/*
        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };

        Function<Integer, Integer> squareNumberFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * number;
            }
        };

        Consumer<Integer> printConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.print(number);
            }
        };
*/

}