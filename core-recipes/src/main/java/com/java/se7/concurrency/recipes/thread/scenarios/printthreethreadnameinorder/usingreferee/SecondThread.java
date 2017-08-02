package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingreferee;



/**
 * Created by ssri52 on 2/9/2017.
 */
public class SecondThread implements Runnable {
    private Referee referee;

    public SecondThread(Referee referee) {
        this.referee = referee;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            referee.waitForMyTurn(2);
            System.out.print(Thread.currentThread().getName());
            referee.done();
        }
    }
}
