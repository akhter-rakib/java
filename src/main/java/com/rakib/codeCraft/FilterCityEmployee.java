package com.rakib.codeCraft;

import com.rakib.mockdata.CityEmployee;
import com.rakib.mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/*Filter Employees by City and Age
Filter a list of Employees to include only those who are younger than 30 years old
Filter employees earning a salary greater than 50000*/
public class FilterCityEmployee {
    @Test
    public void testFilterEmployeesByCityAndAge() {
        int age = 18;
        String city = "Houston";
        List<CityEmployee> employees = MockData.cityEmployees();
        List<CityEmployee> list = employees.stream().
                filter(cityEmployee -> Objects.equals(cityEmployee.getCity(), city) && cityEmployee.getAge() == age)
                .toList();
        assertEquals(1, list.size());
        assertEquals(city, list.get(0).getCity());
    }

    @Test
    public void testFilterEmployeesYoungerThan30() {
        List<CityEmployee> employees = MockData.cityEmployees();
        List<CityEmployee> cityEmployees = employees.stream()
                .filter(cityEmployee -> cityEmployee.getAge() < 30)
                .toList();

        assertEquals(4, cityEmployees.size());
    }

    @Test
    public void testFilterEmployeesEarningSalaryGreaterThan50000() {
        List<CityEmployee> employees = MockData.cityEmployees();
        List<CityEmployee> highEarningEmployees  = employees.stream()
                .filter(cityEmployee -> cityEmployee.getSalary() > 50000)
                .toList();

        assertEquals(3, highEarningEmployees .size());
    }
}
