package com.rakib.java8;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementFromString {

    @Test

    public void findDuplicateElementFromString() {
        String input = "ilovebangladesh";

      /*  Map<Character, Long> collect = input.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        assertEquals(2, collect.size());*/

        List<Character> result = input.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(result);

    }
}
