package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {
        List<String> gradeTwoRedStudents = List.of("Amber", "Anil", "Arjan");
        List<String> gradeTwoGreenStudents = List.of("Binil", "Benny", "Barat");
        List<String> gradeTwoBlueStudents = List.of("Cathy", "Celina", "Coen");
        List<String> gradeTwoYellowStudents = List.of("Bram", "Dhuruv", "Navya");

        List<List<String>> gradeTwoStudents = new ArrayList<>();
        gradeTwoStudents.add(gradeTwoRedStudents);
        gradeTwoStudents.add(gradeTwoGreenStudents);
        gradeTwoStudents.add(gradeTwoBlueStudents);
        gradeTwoStudents.add(gradeTwoYellowStudents);

        System.out.println("gradeTwoStudents=" + gradeTwoStudents);

        List<String> allGradeTwoStudents =
                gradeTwoStudents.stream()
                .flatMap(students -> students.stream())
                .collect(Collectors.toList());

        System.out.println("allGradeTwoStudents=" + allGradeTwoStudents);
    }
}
