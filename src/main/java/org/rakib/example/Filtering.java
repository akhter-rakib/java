package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Car;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws IOException {
        Predicate<Car> pricePredicate = car -> car.getPrice() < 20_000;
        Predicate<Car> colorPredicate = car -> car.getColor().equals("Yellow");
        List<Car> carList = MockData.getCars();
        List<Car> carsLessThan20k = carList.stream()
                .filter(pricePredicate)
                .filter(colorPredicate)
                .toList();

        carsLessThan20k.forEach(System.out::println);
    }

    @Test
    public void dropWhile() {
        /*Using dropWhile*/
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n + " "));
    }

    @Test
    public void takeWhile() {
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n + " "));
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 50)
                .findFirst()
                .orElse(-1);
        System.out.println(result);

    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 9)
                .findAny()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even).allMatch(n -> n % 2 == 0);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd).anyMatch(n -> !(n % 2 == 0));
        System.out.println(anyMatch);
    }
}
