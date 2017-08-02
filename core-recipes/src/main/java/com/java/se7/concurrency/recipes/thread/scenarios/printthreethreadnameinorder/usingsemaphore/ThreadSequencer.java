package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingsemaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class ThreadSequencer {
    private Semaphore firstSemaphore, secondSemaphore, thirdSemaphore;

    public ThreadSequencer() {
        firstSemaphore = new Semaphore(1);
        secondSemaphore = new Semaphore(0);
        thirdSemaphore = new Semaphore(0);
    }

    public void processFirst() {
        try {
            firstSemaphore.acquire();
            System.out.print(Thread.currentThread().getName());
            secondSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processSecond() {
        try {
            secondSemaphore.acquire();
            System.out.print(Thread.currentThread().getName());
            thirdSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processThird() {
        try {
            thirdSemaphore.acquire();
            System.out.println(Thread.currentThread().getName());
            firstSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
