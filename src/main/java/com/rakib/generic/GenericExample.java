package com.rakib.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class GenericExample {
    public static void main(String[] args) {
        IntegerPrint print = new IntegerPrint(12);
        print.print();

        StringPrint stringPrint = new StringPrint("12");
        stringPrint.print();

        /*Generic Example */
        Printer<Integer> printer = new Printer<>(34);
        printer.print();

        /*Generic Example */
        Printer<String> stringPrinter = new Printer<>("TEST");
        stringPrinter.print();
    }

    @Test
    public void notTypeSafe() {
        /*WithOut Generic not type safe*/
        List<Object> list = new ArrayList<>();
        list.add(12);
        list.add("Tst");

        // Check type-unsafe behavior
        assertThrows(ClassCastException.class, () -> {
            String s = (String) list.get(0);// Try to cast Integer to String
        });
    }

    @Test
    public void genericMethod() {
        shout("Hello Generic method");
    }

    @Test
    public void genericListMethod() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(5);
        list.add(5);
        printList(list);
    }

    private static <T> void shout(T t) {
        System.out.println("Things to print: " + t);
    }

    private static void printList(List<?> myList) {
        System.out.println(myList);
    }
}
