package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingsemaphore;

/**
 * Created by ssri52 on 2/8/2017.
 */
public class EvenNumberGenerator implements Runnable {
    private NumberPrinterSemaphore printer;
    private int max;

    public EvenNumberGenerator(NumberPrinterSemaphore printer, int max) {
        this.printer = printer;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i=2; i<=max; i=i+2) {
            printer.printEvenNumber(i);
        }
    }
}
