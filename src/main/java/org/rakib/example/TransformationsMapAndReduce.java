package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Car;
import org.rakib.beans.PeopleDto;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TransformationsMapAndReduce {

    @Test
    public void firstTransactionWithMap() throws IOException {
        List<PeopleDto> dtoList = MockData.getPeople().stream()
                .filter(people -> people.getAge() > 20)
                /*.map(people -> new PeopleDto(people.getId(), people.getFirstName(), people.getAge()))
                .toList();*/
                .map(PeopleDto::map)
                .toList();
        dtoList.forEach(System.out::println);
    }

    @Test
    public void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> carList = MockData.getCars();
        double avg = carList.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers).reduce(0, Integer::sum);
        int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sub);
    }

}
