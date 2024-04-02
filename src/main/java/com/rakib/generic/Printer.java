package com.rakib.generic;

/*T Here is type parameter*/
/*Here is one Printer class that is working for different type of class*/
public class Printer<T> {
    private T thingsToprint;

    public Printer(T thingsToprint) {
        this.thingsToprint = thingsToprint;
    }

    public void print() {
        System.out.println("This to print : " + thingsToprint);
    }
}
