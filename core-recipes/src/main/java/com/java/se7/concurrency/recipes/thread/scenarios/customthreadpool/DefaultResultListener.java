package com.java.se7.concurrency.recipes.thread.scenarios.customthreadpool;

public class DefaultResultListener implements ResultListener {

    @Override
    public void finish(Object obj) {

    }

    @Override
    public void error(Exception ex) {
        ex.printStackTrace();
    }

}
