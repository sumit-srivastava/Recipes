package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingsemaphore;

/**
 * Created by ssri52 on 2/8/2017.
 */
public class Main {
    public static void main(String[] args) {
        NumberPrinterSemaphore printer = new NumberPrinterSemaphore();
        EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator(printer, 50);
        Thread evenNumberGeneratorThread = new Thread(evenNumberGenerator);

        OddNumberGenerator oddNumberGenerator = new OddNumberGenerator(printer, 50);
        Thread oddNumberGeneratorThread = new Thread(oddNumberGenerator);

        evenNumberGeneratorThread.start();
        oddNumberGeneratorThread.start();
    }
}
