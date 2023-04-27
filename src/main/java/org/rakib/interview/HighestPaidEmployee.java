package org.rakib.interview;

import org.junit.jupiter.api.Test;
import org.rakib.beans.Employee;
import org.rakib.mockdata.MockData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestPaidEmployee {
    @Test
    void main() {
        List<Employee> employeeList = MockData.employees();
        Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> collect = employeeList.stream()
                .collect(Collectors.
                        groupingBy(
                                Employee::getDept,
                                Collectors.reducing(BinaryOperator.maxBy(employeeComparator))));
        System.out.println(collect);
    }

    @Test
    void highestPaid() {
        List<Employee> employees = MockData.employees();
        Map<String, Employee> collect = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingDouble(Employee::getSalary)),
                                        Optional::get)
                        )
                );
        System.out.println(collect);
    }

    @Test
    void highestPaidApproach() {
        List<Employee> employees = MockData.employees();
        Map<String, Employee> collect = employees.stream()
                .collect(
                        Collectors.toMap(Employee::getDept,
                                Function.identity(),
                                BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary)))
                );
        System.out.println(collect);
    }
}
