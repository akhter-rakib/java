package org.rakib.example;

import org.junit.jupiter.api.Test;
import org.rakib.beans.People;
import org.rakib.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<People> youngPeople = new ArrayList<>();
        int limit = 10;
        int count = 0;
        List<People> peopleList = MockData.getPeople();
        for (People p : peopleList) {
            if (p.getAge() <= 18) {
                youngPeople.add(p);
                count++;
                if (count == limit)
                    break;
            }
        }
        youngPeople.forEach(System.out::println);
    }

    @Test
    public void declarativeApproach() throws IOException {
        List<People> peopleList = MockData.getPeople();
        List<People> list = peopleList.stream()
                .filter(people -> people.getAge() <= 18)
                .limit(10)
                .toList();
        list.forEach(System.out::println);
    }
}
