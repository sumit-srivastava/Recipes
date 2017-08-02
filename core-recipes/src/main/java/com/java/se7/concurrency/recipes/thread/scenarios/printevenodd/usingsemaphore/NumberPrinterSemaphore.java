package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingsemaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by ssri52 on 2/8/2017.
 */
public class NumberPrinterSemaphore {
    private Semaphore oddSemaphore;
    private Semaphore evenSemaphore;

    public NumberPrinterSemaphore() {
        oddSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
    }

    public void printEvenNumber(int number) {
        try {
            evenSemaphore.acquire();
            System.out.printf("Thread: %s ::: Number: %d.\n", Thread.currentThread().getName(), number);
            oddSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printOddNumber(int number) {
        try {
            oddSemaphore.acquire();
            System.out.printf("Thread: %s ::: Number: %d.\n", Thread.currentThread().getName(), number);
            evenSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
