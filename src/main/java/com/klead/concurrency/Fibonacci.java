package com.klead.concurrency;

import java.util.concurrent.*;

/**
 * Created by kafi on 03/03/2016.
 */
public class Fibonacci {

    private ExecutorService executor;

    public void execute(int number) {
        executor = Executors.newSingleThreadExecutor();
        FibonacciCalculator op = new FibonacciCalculator(number);
        System.out.println("Beginning to process Fibonacci the new style");
        Future<Long> result = executor.submit(op);
        try {
            while (!result.isDone() && !result.isCancelled()) {
                System.out.print("#");
                Thread.sleep(500);
            }
            if (result.isDone()) {
                System.out.println("\n Result of callable: " + result.get());
            }
            // handling cancellation
            else if (result.isCancelled()) {
                System.out.println("\n execution was cancelled!");
            }
        } catch (InterruptedException ie) {
            System.out.println("UI Thread was interrupted!");
        } catch (ExecutionException ee) {
            System.out.println("Processing of operation threw excpetion!");
        }
    }

    public class FibonacciCalculator implements Callable<Long> {
        private int number;

        public FibonacciCalculator(int n) {
            this.number = n;
        }

        public Long call() throws Exception {
            return fibonacci(number);
        }

        private Long fibonacci(int n) {

            if (n <= 1)
                return 1L;
            else
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


}
