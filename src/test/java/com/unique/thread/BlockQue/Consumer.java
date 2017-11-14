package com.unique.thread.BlockQue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> queue;
    Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+"消费");
        String tmp = null;
        try {
            tmp = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tmp);
    }
}
