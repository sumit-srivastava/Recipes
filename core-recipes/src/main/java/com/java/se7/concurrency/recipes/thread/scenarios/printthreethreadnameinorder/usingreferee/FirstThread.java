package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingreferee;



/**
 * Created by ssri52 on 2/9/2017.
 */
public class FirstThread implements Runnable {
    private Referee referee;

    public FirstThread(Referee referee) {
        this.referee = referee;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            referee.waitForMyTurn(1);
            System.out.print(Thread.currentThread().getName());
            referee.done();
        }
    }
}
