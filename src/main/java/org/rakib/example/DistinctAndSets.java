package org.rakib.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctAndSets {

    @Test
    public void distinct() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinctValue = numbers.stream().distinct().toList();
        assertThat(distinctValue).hasSize(9);
        System.out.println(distinctValue);
    }

    @Test
    public void distinctWithSet() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinctValue = new HashSet<>(numbers);
        assertThat(distinctValue).hasSize(9);
        System.out.println(distinctValue);
    }
}
