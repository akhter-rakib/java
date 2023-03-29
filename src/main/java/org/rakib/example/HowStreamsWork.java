package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.mockdata.MockData;

import java.io.IOException;

public class HowStreamsWork {

    @Test
    public void intermediateAndTerminalOperations() throws IOException {

        System.out.println(MockData.getCars().stream()
                .filter(car -> {
                    System.out.println("filter car " + car);
                    return car.getPrice() < 10000;
                })
                .map(car -> {
                    System.out.println("mapping car " + car);
                    return car.getPrice();
                })
                .map(car -> {
                    System.out.println("mapping price " + car);
                    return car + (car * 2);
                })
                .toList());

    }
}
