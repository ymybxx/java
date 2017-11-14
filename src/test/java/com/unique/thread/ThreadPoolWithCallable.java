package com.unique.thread;

import java.util.concurrent.*;

public class ThreadPoolWithCallable {

    public static void main(String[] args) {
        ExecutorService exf = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 10; i++) {
            Future<String> future = exf.submit(new Callable<String>() {
                public String call() throws Exception {
                    return Thread.currentThread().getName();

                }
            });
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
