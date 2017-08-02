package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingsemaphore;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class SecondThread implements Runnable {
    private ThreadSequencer sequencer;

    public SecondThread(ThreadSequencer sequencer) {
        this.sequencer = sequencer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            sequencer.processSecond();
        }
    }
}
