package com.rakib.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

public class FirstHighestNumberFinder {

    @Test
    public void highestNumberFromGivenArray() {
        int[] input = {10, 30, 20, 50, 40};
      /*  int firstHighest = findFirstHighestNumberByImperativeWay(input);
        System.out.println(firstHighest);*/

        OptionalInt firstHighestNumberByDeclarativeApproach = findFirstHighestNumberByDeclarativeApproach(input);
        firstHighestNumberByDeclarativeApproach.ifPresent(System.out::println);
    }

    /*imperativeApproach*/
    public int findFirstHighestNumberByImperativeWay(int[] values) {
        int max = Integer.MIN_VALUE;

        for (int num : values) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /*declarativeApproach*/
    public OptionalInt findFirstHighestNumberByDeclarativeApproach(int[] values) {
       return Arrays.stream(values)
                .max();
    }
}
