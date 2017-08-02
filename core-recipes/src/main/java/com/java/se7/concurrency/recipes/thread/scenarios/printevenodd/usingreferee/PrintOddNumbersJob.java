package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingreferee;

public class PrintOddNumbersJob implements Runnable {

    private Referee referee;

    public PrintOddNumbersJob(Referee referee) {
        this.referee = referee;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {

            referee.waitMyTurn(false);

            System.out.println(i);

            referee.done();
        }
    }
}