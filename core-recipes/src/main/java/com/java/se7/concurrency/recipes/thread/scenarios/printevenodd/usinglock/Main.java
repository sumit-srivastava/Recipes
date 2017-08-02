package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usinglock;



/**
 * Created by ssri52 on 2/8/2017.
 */
public class Main {
    public static void main(String[] args) {
        NumberPrinterLock printer = new NumberPrinterLock();
        EvenNumberGenerator evenNumbersJob = new EvenNumberGenerator(printer, 50);
        OddNumberGenerator oddNumbersJob = new OddNumberGenerator(printer, 50);
        Thread evenJobThread = new Thread(evenNumbersJob);
        Thread oddJobThread = new Thread(oddNumbersJob);

        evenJobThread.start();
        oddJobThread.start();
    }
}
