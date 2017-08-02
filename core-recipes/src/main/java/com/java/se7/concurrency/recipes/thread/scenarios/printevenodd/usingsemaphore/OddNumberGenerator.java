package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingsemaphore;

/**
 * Created by ssri52 on 2/8/2017.
 */
public class OddNumberGenerator implements Runnable {
    private NumberPrinterSemaphore printer;
    private int max;

    public OddNumberGenerator(NumberPrinterSemaphore printer, int max) {
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
