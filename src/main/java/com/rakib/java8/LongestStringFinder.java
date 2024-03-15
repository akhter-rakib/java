package com.rakib.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestStringFinder {

    @Test
    public void longestStringFromGivenArray() {
        String[] input = {"apple", "banana", "orange", "strawberry", "kiwi"};
        String result = findLongestStringByDeclarativeApproach(input);
        System.out.println(result);
    }

    /*imperativeApproach*/
    public String findLongestString(String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        String longestValue = values[0];
        for (String val : values) {
            if (val.length() > longestValue.length()) {
                longestValue = val;
            }
        }
        return longestValue;
    }

    /*declarativeApproach*/
    public String findLongestStringByDeclarativeApproach(String[] values) {
        Optional<String> maxSizeValue = Arrays.stream(values)
                .max(Comparator.comparingInt(String::length));
        return maxSizeValue.orElseThrow(() ->
                new IllegalArgumentException("Input array must contain at least one non-null element"));
    }


}
