package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingreferee;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class Main {
    public static void main(String[] args) {
        Referee referee = new Referee();
        FirstThread firstThread = new FirstThread(referee);
        SecondThread secondThread = new SecondThread(referee);
        ThirdThread thirdThread = new ThirdThread(referee);

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
