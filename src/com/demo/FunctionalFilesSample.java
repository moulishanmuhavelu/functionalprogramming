package com.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FunctionalFilesSample {

    public static void main(String[] args) throws IOException {

         Files.lines(Paths.get("sample.txt"))
            .map(str -> str.split(" "))
            .flatMap(Arrays::stream)
            .distinct()
            .sorted()
            .forEach(System.out::println);

    }
}