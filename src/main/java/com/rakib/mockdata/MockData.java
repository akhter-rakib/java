package com.rakib.mockdata;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.rakib.beans.Car;
import com.rakib.beans.Person;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockData {
    public static List<Person> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Person>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Car> getCar() throws IOException {
        InputStream inputStream = Resources.getResource("cars.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static Map<String, Double> employee() {
        return Map.ofEntries(
                Map.entry("anil", 1000.00),
                Map.entry("bhavna", 130.00),
                Map.entry("micael", 1500.00),
                Map.entry("tom", 1600.00),
                Map.entry("ankit", 1200.00),
                Map.entry("ankur", 1200.00),
                Map.entry("daniel", 1700.00),
                Map.entry("daniel angel", 1700.00),
                Map.entry("james", 1400.00),
                Map.entry("rakib", 45400.00)
        );
    }

    public static List<Employee> employeeList() {
        return List.of(
                new Employee("Rakib", 1000),
                new Employee("Sakib", 1200),
                new Employee("Akib", 1400)
        );
    }
}
