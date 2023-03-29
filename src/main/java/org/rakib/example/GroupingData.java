package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Car;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
}
