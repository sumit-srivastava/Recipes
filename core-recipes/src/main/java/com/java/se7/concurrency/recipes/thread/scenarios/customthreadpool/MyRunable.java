package com.java.se7.concurrency.recipes.thread.scenarios.customthreadpool;

import java.util.concurrent.Callable;

class MyRunable implements Callable {
    int index = -1;

    public MyRunable(int index) {
        this.index = index;
    }

    @Override
    public Integer call() throws Exception {
        return index;
    }

}