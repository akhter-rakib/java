package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Car;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws IOException {
        List<Car> carList = MockData.getCars();
        Map<String, List<Car>> carMap = carList.stream()
                .collect(Collectors.groupingBy(Car::getMake));

        carMap.forEach((s, cars) -> {
            System.out.println("Make " + s);
            cars.forEach(System.out::println);
            System.out.println("---------------------");
        });
    }

    @Test
    public void groupingAndCounting() {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );
        Map<String, Long> collect = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(collect);
    }

    @Test
    void countByMake() throws IOException {
        List<Car> cars = MockData.getCars();
        Map<String, Long> collect = cars.stream()
                .collect(Collectors.groupingBy(
                        Car::getMake,
                        Collectors.counting()
                ));
        System.out.println(collect);
    }

    @Test
    void highestPriceMake() throws IOException {
        Map<String, Optional<Car>> collect = MockData.getCars().stream()
                .collect(
                        Collectors.groupingBy(
                                Car::getMake,
                                Collectors.maxBy(Comparator.comparingDouble(Car::getPrice))
                        )
                );
        System.out.println(collect);
    }
    @Test
    void highestPriceMakeCarID() throws IOException {
        Map<String, Optional<Integer>> collect = MockData.getCars().stream()
                .collect(
                        Collectors.groupingBy(
                                Car::getMake,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Car::getPrice)),
                                        car -> car.map(Car::getId)
                                )
                        )
                );
        System.out.println(collect);
    }
}
