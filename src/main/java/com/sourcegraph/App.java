package com.sourcegraph;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcegraph.cup.Cup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws Exception {
        App app = new App();
        app.run(args);
    }

    public void run(String... args) throws Exception {

        Cup<Double> floatingCup = new Cup<>(42.0);

        log.info("Diagnostic message: {}", floatingCup);

        {
            String log = "I'm another log. I shadow that log up there.";
            System.out.println(log);
        }

        floatingCup.refill(10);

        Double cupContents = floatingCup.pour();

        log.info("Got {} out of the cup!", cupContents);

        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    System.out.println("Interrupted while waiting");
                }
            }
        }
    }

    @JsonInclude
    public void whatever() {
        new Cup<String>("some string") {}.refill("some more string");
        Broken.foo();
    }
}
