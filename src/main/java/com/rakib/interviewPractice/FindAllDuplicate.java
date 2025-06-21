package com.rakib.interviewPractice;

import java.util.*;

public class FindAllDuplicate {

    /*Brute-Force Version (O(n²))*/
    static List<Integer> findDuplicatesBruteForce(int[] array) {
        List<Integer> dups = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j] && !dups.contains(array[i])) {
                    dups.add(array[i]);
                }
            }
        }
        return dups;
    }

    /*HashSet-Based Version (O(n))*/
    static List<Integer> findDuplicates(int[] args) {

        if (args == null || args.length < 2) {
            return Collections.emptyList();
        }
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int arg : args) {
            if (!seen.add(arg)) {
                duplicates.add(arg);
            }
        }
        return new ArrayList<>(duplicates);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 3};
        List<Integer> list = findDuplicates(arr);
        /*ArrayList<Integer> list = findAllDuplicate(arr);*/
        System.out.println(list); // Output: [2, 3]
    }
}
