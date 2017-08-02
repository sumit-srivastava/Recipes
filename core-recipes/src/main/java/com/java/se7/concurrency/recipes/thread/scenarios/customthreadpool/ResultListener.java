package com.java.se7.concurrency.recipes.thread.scenarios.customthreadpool;

/**
 * This interface imposes finish method
 * which is used to get the {@link Output} object
 * of finished task
 *
 * @param
 * @author abhishek
 */

public interface ResultListener<T> {

    public void finish(T obj);

    public void error(Exception ex);

}