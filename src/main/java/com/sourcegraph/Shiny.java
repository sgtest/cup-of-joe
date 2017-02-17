package com.sourcegraph;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings("HEY")
@Retention(RetentionPolicy.CLASS)
@Shiny(isSparkly = true)
public @interface Shiny {

    boolean isSparkly() default false;

}
