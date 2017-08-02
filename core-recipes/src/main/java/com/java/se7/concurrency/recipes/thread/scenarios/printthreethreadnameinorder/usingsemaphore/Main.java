package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingsemaphore;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class Main {
    public static void main(String[] args) {
        ThreadSequencer sequencer = new ThreadSequencer();
        FirstThread firstThread = new FirstThread(sequencer);
        SecondThread secondThread = new SecondThread(sequencer);
        ThirdThread thirdThread = new ThirdThread(sequencer);

        Thread firstJob = new Thread(firstThread);
        firstJob.setName("A");
        Thread secondJob = new Thread(secondThread);
        secondJob.setName("B");
        Thread thirdJob = new Thread(thirdThread);
        thirdJob.setName("C");

        firstJob.start();
        secondJob.start();
        thirdJob.start();
    }
}
