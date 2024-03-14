package com.rakib.java8;

import com.rakib.mockdata.MockData;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {

    @Test
    public void nthHighestSalary() {
        Map<String, Double> employees = MockData.employee();

        Map.Entry<Double, List<String>> nthHighestSalary = getDynamicNthHighestSalary(1, employees);
        System.out.println(nthHighestSalary);

    }

    private static Map.Entry<Double, List<String>> getDynamicNthHighestSalary(int num, Map<String, Double> map) {

        return map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(num - 1);
    }

}
