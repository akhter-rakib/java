package org.rakib.design_patterns.singleton;

public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton singleton = null;

    public static DoubleCheckedLockingSingleton getInstance() {
        if (singleton == null) {
            //To make thread safe
            synchronized (DoubleCheckedLockingSingleton.class) {
                // check again as multiple threads
                // can reach above step
                if (singleton == null) {
                    singleton = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return singleton;
    }
}
