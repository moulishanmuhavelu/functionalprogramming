package com.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadPracticesSample {

    public static void main(String[] args) throws IOException {

            List<String> names = List.of();
            names.stream()
                    .sorted()
                    .map(String::toUpperCase)
                    .filter(name -> name.length() < 5)
                    .forEach(System.out :: println);
        }
}