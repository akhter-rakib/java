package com.rakib.codeCraft;

import com.rakib.mockdata.MockData;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalaryCalculator {
    public static void main(String[] args) {
        Map<String, Double> employees = MockData.employee();

        Map.Entry<Double, List<String>> nthHighestSalary = getDynamicNthHighestSalary(1, employees);
        System.out.println(nthHighestSalary);
    }

    /*leading to incorrect results where there are duplicate salary values.*/
    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map) {

        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList()
                .get(num - 1);
    }

    public static Map.Entry<Double, List<String>> getDynamicNthHighestSalary(int num, Map<String, Double> map) {
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
