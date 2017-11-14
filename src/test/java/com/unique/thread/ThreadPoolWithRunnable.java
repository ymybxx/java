package com.unique.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolWithRunnable {
    public static void main(String[] args) {
        ExecutorService exc = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            exc.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"is running");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        exc.shutdown();
    }
}
