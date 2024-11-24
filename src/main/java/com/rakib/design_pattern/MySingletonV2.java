package com.rakib.design_pattern;

import java.io.Serializable;

public class MySingletonV2 implements Serializable, Cloneable {

    private static MySingletonV2 singletonV2;

    private MySingletonV2() {
        /*Protect against reflection attacking*/
        if (singletonV2 != null) {
            throw new IllegalStateException("Singleton Instance already created");
        }
    }

    /*Protect against serialization*/
    private Object readResolve() {
        return singletonV2;
    }

    /*Protest against cloning*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cloning is not allowed");
    }
}
