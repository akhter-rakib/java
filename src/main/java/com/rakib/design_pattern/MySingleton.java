package com.rakib.design_pattern;

public class MySingleton {

    private static MySingleton singleton;

    // Private constructor to prevent instantiation
    private MySingleton() {

    }

    public static MySingleton getInstance() {
        if (singleton == null) {
            /*thread-safe way to implement lazy initialization efficiently with double check*/
            synchronized (MySingleton.class) {
                if (singleton == null) {
                    singleton = new MySingleton();
                }
            }

        }
        return singleton;
    }

}
