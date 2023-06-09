package org.rakib.design_patterns.singleton;

public class EagerInstantiationSingleton {

    private static EagerInstantiationSingleton eagerInstantiationSingleton
            = new EagerInstantiationSingleton();


    private EagerInstantiationSingleton() {

    }

    public static EagerInstantiationSingleton getInstance() {
        return eagerInstantiationSingleton;
    }
}
