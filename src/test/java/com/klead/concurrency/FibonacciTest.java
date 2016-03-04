package com.klead.concurrency;

import org.junit.Test;

/**
 * Created by kafi on 03/03/2016.
 */
public class FibonacciTest {

    @Test
    public void fibonacciTest() {
        Fibonacci f = new Fibonacci();
        f.execute(3);

    }
}
