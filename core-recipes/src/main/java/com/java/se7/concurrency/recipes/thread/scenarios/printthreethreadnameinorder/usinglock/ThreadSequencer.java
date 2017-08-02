package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usinglock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class ThreadSequencer {
    private Lock lock;
    private Condition firstOrderCondition, secondOrderCondition, thirdOrderCondition;
    private int turn;

    public ThreadSequencer() {
        lock = new ReentrantLock();
        turn = 1;
        firstOrderCondition = lock.newCondition();
        secondOrderCondition = lock.newCondition();
        thirdOrderCondition = lock.newCondition();
    }

    public void processFirst() {
        lock.lock();
        try {
            while (turn != 1) {
                firstOrderCondition.await();
            }
            System.out.print(Thread.currentThread().getName());
            turn = 2;
            secondOrderCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void processSecond() {
        lock.lock();
        try {
            while (turn != 2) {
                secondOrderCondition.await();
            }
            System.out.print(Thread.currentThread().getName());
            turn = 3;
            thirdOrderCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void processThird() {
        lock.lock();
        try {
            while (turn != 3) {
                thirdOrderCondition.await();
            }
            System.out.println(Thread.currentThread().getName());
            turn = 1;
            firstOrderCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
