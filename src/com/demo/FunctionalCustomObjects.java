package com.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalCustomObjects {

    public static void main(String args[]) {
        List<Product> products = List.of(
                new Product("Samsung S11" ,"phone", 750, 300),
                new Product("Sony wireless headset" , "audio",290, 45),
                new Product("Apple Macbook" , "laptop",3500, 100),
                new Product("Dell Inspiron" , "laptop",1290, 74),
                new Product("Apple ipad" , "tab",800, 185),
                new Product("Amazon Kindle" , "tab",139, 870),
                new Product("Apple iphone" , "phone",900, 1200)
        );

        Comparator<Product> compareByStockAvailability = Comparator.comparingInt(Product::getStockAvailability).reversed();

        System.out.println(
            products.stream()
                    .filter(p -> p.getStockAvailability() > 100)
                    .sorted(compareByStockAvailability)
                    .collect(Collectors.toList()) );


        System.out.println(
                products.stream()
                        .collect(Collectors.groupingBy(Product::getProductType)) );


    }
}

    class Product {
        private String name;
        private String productType;
        private int price;
        private int stockAvailability;

        public Product(String name, String productType, int price, int stockAvailability) {
            this.name = name;
            this.productType = productType;
            this.price = price;
            this.stockAvailability = stockAvailability;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getStockAvailability() {
            return stockAvailability;
        }

        public void setStockAvailability(int stockAvailability) {
            this.stockAvailability = stockAvailability;
        }

        public String toString() {
            return name + ":" + productType + ":" + price + ":" + stockAvailability;
        }
    }