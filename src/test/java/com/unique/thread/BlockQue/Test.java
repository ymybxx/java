package com.unique.thread.BlockQue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        for (int i = 0; i < 3; i++) {
            new Thread(producer,"producer "+ i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "producer " + i).start();
        }
    }
}
