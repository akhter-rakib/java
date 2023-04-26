package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Item;
import org.rakib.beans.Order;
import org.rakib.beans.OrderDto;
import org.rakib.mockdata.MockData;

import java.util.List;

public class TransformationsWithFlatMap {
    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @Test
    public void withFlatMap() {
        System.out.println(arrayListOfNames.stream()
                .flatMap(name -> name.stream().map(String::toUpperCase)).toList());
    }

    @Test
    public void withFlatMapForObject() {
        List<Order> list = MockData.orders();
        List<OrderDto> orderDos = list.stream()
                .map(order -> new OrderDto(order.getOrderId(),
                        order.getItems().stream()
                                .map(Item::getName)
                                .toList()
                )).toList();

        System.out.println(orderDos);

    }
}
