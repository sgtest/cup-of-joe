package com.sourcegraph;

public class App {

    private Timer timer = new Timer();

    public static void main(String... args) throws Exception {
        App app = new App();
        app.run(args);
    }

    public void run(String... args) throws Exception {

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
