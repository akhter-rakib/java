package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Car;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws IOException {
        List<Car> carList = MockData.getCars();
        long carCount = carList.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .filter(car -> car.getYear() > 2010)
                .count();
        System.out.println(carCount);
    }

    @Test
    public void min() throws IOException {
        List<Car> carList = MockData.getCars();
        double val = carList.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println(val);

    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        double max = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(max);
    }

    @Test
    public void average() throws IOException {
        List<Car> cars = MockData.getCars();
        double averageValue = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(averageValue);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        System.out.println(sum);
    }

    @Test
    public void statistics() throws IOException {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics =
                cars.stream()
                        .mapToDouble(Car::getPrice)
                        .summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());
    }

}
