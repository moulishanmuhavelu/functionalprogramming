package com.demo;

public class ImPureFunctionSample {

    private static int value;

    public static int incrementBy(int number) { return (value += number); }

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            System.out.println(incrementBy(1));
        }
    }
}