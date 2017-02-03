package com.sourcegraph.cup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A cup of T
 * @param <T> (whatever you want)
 */
public class Cup<T> {

    private static final Logger log = LoggerFactory.getLogger(Cup.class);

    static public List<String> SIZES;

    static {
        SIZES = new ArrayList<>();
        for (String size : new String[]{ "small", "medium", "large" }) {
            SIZES.add(size);
        }
    }

    private T stuff;

    public Cup(T stuff) {
        this.stuff = stuff;
    }

    public T pour() {
        return stuff;
    }

    public String toString() {
        return "I'm a cup of " + stuff.toString() + "!";
    }

    /**
     * Refill the cup with U (which had better be castable to T!)
     * @param moreStuff
     * @param <U> (will be cast to T)
     */
    public <U> void refill(U moreStuff) {
        try {
            stuff = (T) moreStuff; // unsafe cast
        } catch (Exception e) {
            log.error("Couldn't refill cup with {}", moreStuff.getClass().getName());
            e.printStackTrace();
        }
    }
}
