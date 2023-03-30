package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Car;
import org.rakib.beans.People;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<String> sorted = MockData.getPeople()
                .stream()
                .map(People::getEmail)
                .sorted()
                .toList();
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<String> sorted = MockData.getPeople()
                .stream()
                .map(People::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList();
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        Comparator<People> comparing = Comparator
                .comparing(People::getEmail)
                .reversed()
                .thenComparing(People::getFirstName);

        List<People> sort = MockData.getPeople()
                .stream()
                .sorted(comparing)
                .toList();
        sort.forEach(System.out::println);
    }


    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> topTen = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(10)
                .toList();
        topTen.forEach(System.out::println);
    }
}
