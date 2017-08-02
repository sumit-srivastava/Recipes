package com.java.se7.concurrency.recipes.thread.scenarios.printthreethreadnameinorder.usingreferee;

/**
 * Created by ssri52 on 2/9/2017.
 */
public class Referee {
    private int turn;

    public Referee() {
        turn = 1;
    }

    public void waitForMyTurn(int order) {
        synchronized (this) {
            while (turn != order) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void done() {
        synchronized (this) {
            if (turn == 3) {
                turn = 1;
            } else {
                turn += 1;
            }
            notifyAll();
        }
    }
}
