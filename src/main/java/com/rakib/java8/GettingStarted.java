package com.rakib.java8;


import com.rakib.beans.Person;
import com.rakib.mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> person = MockData.getPeople();
        List<Person> youngPerson = new ArrayList<>();
        int limit = 10;
        int counter = 0;
        for (Person p : person) {
            if (p.getAge() <= 18) {
                youngPerson.add(p);
                counter++;
                if (counter == limit) {
                    break;
                }
            }
        }
        youngPerson.forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> personList = people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .toList();
        personList.forEach(System.out::println);
    }

}
