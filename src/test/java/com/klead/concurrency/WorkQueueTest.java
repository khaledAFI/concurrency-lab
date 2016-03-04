package com.klead.concurrency;

import org.junit.Test;

/**
 * Created by kafi on 03/03/2016.
 */
public class WorkQueueTest {
    @Test
    public void testExecute(){
        Runnable[] jobs =  new Runnable[5];
        // init jobs
        for (int i =0; i < 5 ; i++) {
            jobs[i]  = new Runnable() {
                public void run() {
                    System.out.println( "Hello "+this.toString() );
                }
            };
        }
        // init queue
        WorkQueue wq = new WorkQueue(5);
        for (Runnable job : jobs) {
            wq.execute(job);
        }
    }

}
