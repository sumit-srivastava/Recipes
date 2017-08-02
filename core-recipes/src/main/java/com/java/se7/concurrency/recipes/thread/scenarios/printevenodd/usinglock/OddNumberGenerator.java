package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usinglock;

/**
 * Created by ssri52 on 2/8/2017.
 */
public class OddNumberGenerator implements Runnable {
    private NumberPrinterLock printer;
    private int max;

    public OddNumberGenerator(NumberPrinterLock printer, int max) {
        this.printer = printer;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i=1; i<=max; i=i+2) {
            printer.printOddNumber(i);
        }
    }
}
