package com.klead.concurrency;

import java.util.concurrent.Callable;

/**
 * Created by kafi on 03/03/2016.
 */
public class MyCallable1 implements Callable<String> {

    private long waitTime;

    public MyCallable1(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}
