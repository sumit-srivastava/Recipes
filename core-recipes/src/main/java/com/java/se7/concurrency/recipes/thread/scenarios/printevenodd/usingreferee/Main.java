package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingreferee;


/**
 * Created by ssri52 on 2/8/2017.
 */
public class Main {
    public static void main(String[] args) {
        Referee referee = new Referee();
        PrintEvenNumbersJob evenNumbersJob = new PrintEvenNumbersJob(referee);
        PrintOddNumbersJob oddNumbersJob = new PrintOddNumbersJob(referee);

        Thread evenJobThread = new Thread(evenNumbersJob);
        Thread oddJobThread = new Thread(oddNumbersJob);

        evenJobThread.start();
        oddJobThread.start();
    }
}
