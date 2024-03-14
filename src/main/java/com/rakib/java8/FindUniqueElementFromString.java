package com.rakib.java8;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindUniqueElementFromString {

    @Test
    public void findUniqueElementFromString() {
        String input = "iitscc";

        List<Character> t = input.chars().mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(t);
    }
}
