package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

@FunctionalInterface
public interface MyFunctionalInterface<T> {
    public void execute();

    public default void print(String text) {
        System.out.println(text);
    }
    public static void print(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }
}
