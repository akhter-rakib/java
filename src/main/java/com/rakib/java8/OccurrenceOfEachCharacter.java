package com.rakib.java8;

import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class OccurrenceOfEachCharacter {

    @Test
    public void occurrenceOfEachCharacter() {
        String input = "IloveJavaProgramming";
        Map<String, Long> collect = Stream.of(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        assertEquals(Long.valueOf(3), collect.get("a"));
    }
}
