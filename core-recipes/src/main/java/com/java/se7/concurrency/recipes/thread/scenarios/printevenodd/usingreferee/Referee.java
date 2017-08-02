package com.java.se7.concurrency.recipes.thread.scenarios.printevenodd.usingreferee;

public class Referee {
    private boolean evensTurn = false;

    public void waitMyTurn(boolean even) {
        synchronized(this) {
            while (even != evensTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    }

    public void done() {
        synchronized(this) {
            evensTurn = !evensTurn;
            notify();
        }
    }
}