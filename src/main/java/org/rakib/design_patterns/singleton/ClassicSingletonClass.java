package org.rakib.design_patterns.singleton;

public class ClassicSingletonClass {

    private static ClassicSingletonClass singletonClass;

    private ClassicSingletonClass() {

    }

    public static ClassicSingletonClass getInstance() {
        if (singletonClass == null)
            singletonClass = new ClassicSingletonClass();
        return singletonClass;
    }
}
/*The main problem with above method is that it is not thread safe.
 Consider the following execution sequence.*/