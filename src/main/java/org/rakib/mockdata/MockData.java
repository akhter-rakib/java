package org.rakib.mockdata;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.rakib.beans.Car;
import org.rakib.beans.Employee;
import org.rakib.beans.Item;
import org.rakib.beans.Order;
import org.rakib.beans.People;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockData {

    public static List<People> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));
        Type listType = new TypeToken<ArrayList<People>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Car> getCars() throws IOException {
        InputStream inputStream = Resources.getResource("cars.json").openStream();
        String json = IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Order> orders() {
        Order order = new Order(1, Arrays.asList(
                new Item("Product A", 2, 10.00),
                new Item("Product B", 1, 5.00)));
        Order ord2 = new Order(2, Arrays.asList(
                new Item("Product C", 4, 15.00),
                new Item("Product D", 5, 58.00)));
        Order ord3 = new Order(3, Arrays.asList(
                new Item("Product E", 6, 18.00),
                new Item("Product F", 7, 52.00)));
        return List.of(order, ord2, ord3);
    }

    public static List<Employee> employees() {
        return Arrays.asList(
                new Employee(1, "Rakib", "CSE", 12_00.00),
                new Employee(2, "Kasem", "CSE", 10_00.00),
                new Employee(3, "Hasib", "BBA", 12_00.00),
                new Employee(4, "Bokum", "BBA", 19_00.00)
        );
    }
}
