package org.rakib.interview;

import java.util.HashMap;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FrequencyCharacter {
    /*Using stream find frequency of each character in a given String ?
     also try to do without stream ?*/
    public static void main(String[] args) {
        String input = "Basanta";
        Map<Character, Long> collect = input.chars()
                .mapToObj(value -> (char) value)
                .filter(Character::isLetterOrDigit)
                .collect(groupingBy(identity(), counting()));
        System.out.println(collect);

        /*without stream*/
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println(map);
    }
}
