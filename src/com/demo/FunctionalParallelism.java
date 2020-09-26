package com.demo;

import java.util.List;
import java.util.stream.LongStream;

public class FunctionalParallelism {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        LongStream.range(0,1000000000).parallel().sum();
        System.out.println("Time taken with Parallel threads:    " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        LongStream.range(0,1000000000).sum();
        System.out.println("Time taken without Parallel threads: " + (System.currentTimeMillis() - time));


    }

}