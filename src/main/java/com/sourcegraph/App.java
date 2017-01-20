package com.sourcegraph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    private Timer timer = new Timer();

    public static void main(String... args) throws Exception {
        App app = new App();
        app.run(args);
    }

    public void run(String... args) throws Exception {

        log.info("Starting the timer!");

        {
            String log = "I'm a log.";
            System.out.println(log);
        }

        timer.start();

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
}
