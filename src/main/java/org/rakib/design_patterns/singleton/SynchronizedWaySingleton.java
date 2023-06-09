package org.rakib.design_patterns.singleton;

public class SynchronizedWaySingleton {

    private static SynchronizedWaySingleton synchronizedWaySingleton;

    private SynchronizedWaySingleton() {
    }

    // Only one thread can execute this at a time
    public static synchronized SynchronizedWaySingleton getInstance() {
        if (synchronizedWaySingleton == null)
            synchronizedWaySingleton = new SynchronizedWaySingleton();
        return synchronizedWaySingleton;
    }
}
/*ere using synchronized makes sure that only one thread at a time can execute getInstance().
The main disadvantage of this is method is that using synchronized every time while creating the
singleton object is expensive and may decrease the performance of your program*/
