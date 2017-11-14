package com.unique.thread.BlockQue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    public void run() {
        System.out.println("I have made a product "+Thread.currentThread().getName());
        String tmp = "A product" + Thread.currentThread().getName();
        try {
            queue.put(tmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
