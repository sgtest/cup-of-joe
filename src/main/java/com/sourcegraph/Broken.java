package com.sourcegraph;

import com.sourcegraph.Bogus;

public class Broken {

    Bogus bogus = new Bogus();

    static void foo() {
        System.out.println(bogus.toString());
    }
}
