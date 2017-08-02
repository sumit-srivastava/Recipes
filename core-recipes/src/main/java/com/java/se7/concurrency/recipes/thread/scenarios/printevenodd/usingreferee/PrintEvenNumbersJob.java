package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingreferee;

public class PrintEvenNumbersJob implements Runnable {

    private Referee referee;

    public PrintEvenNumbersJob(Referee referee) {
        this.referee = referee;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 100; i += 2) {

            referee.waitMyTurn(true);

            System.out.println(i);

            referee.done();
        }
    }
}