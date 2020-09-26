package com.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class PureFunctionSample {

    private static int value;

    public static int addOne(int input) { return input + 1; }

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            System.out.println(addOne(value));
        }
    }
}