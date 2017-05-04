package com.sourcegraph.bowl;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@JsonInclude
public class Bowl<T> {

    @JsonInclude
    private static final Logger log = LoggerFactory.getLogger(Bowl.class);

    public static List<String> SIZES;

    static {
        SIZES = new ArrayList<>();
        for (String size : new String[]{ "small", "regular" }) {
            SIZES.add(size);
        }
    }

    private T stuff;

    public Bowl(T stuff) {
        this.stuff = stuff;
    }

    public T pour() {
        return stuff;
    }

    @JsonInclude
    public String toString() {
        return "I'm a bowl of " + stuff.toString() + "!";
    }

    /**
     * Refill the bowl with U (which had better be castable to T!)
     * @param moreStuff
     * @param <U> (will be cast to T)
     */
    public <U> void refill(U moreStuff) {
        try {
            stuff = (T) moreStuff; // unsafe cast
        } catch (Exception e) {
            log.error("Couldn't refill bowl with {}", moreStuff.getClass().getName());
            e.printStackTrace();
        }
    }
}
