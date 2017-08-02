package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usinglock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class NumberPrinterLock {
    private Lock lock;
    private Condition evenCondtion;
    private Condition oddCondition;
    private boolean evensTurn;

    public NumberPrinterLock() {
        evensTurn = false;
        lock = new ReentrantLock();
        evenCondtion = lock.newCondition();
        oddCondition = lock.newCondition();
    }

    public void printEvenNumber(int number) {
        lock.lock();
        try {
            while(!evensTurn) {
                evenCondtion.await();
            }
            System.out.println(number);
            evensTurn = false;
            oddCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printOddNumber(int number) {
        lock.lock();
        try {
            while(evensTurn) {
                oddCondition.await();
            }
            System.out.println(number);
            evensTurn = true;
            evenCondtion.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
