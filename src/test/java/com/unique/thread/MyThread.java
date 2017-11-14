package com.unique.thread;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.unique.thread.MyThread.tickets;


public class MyThread {
    static volatile  int tickets = 10;
    static int num = 3;
    static Lock lock = new ReentrantLock();


    public void read(){}
    public synchronized void test1(){
        for (int i = 0; i <10; i++) {
            System.out.println("我是第一个方法");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void test2(){
        for (int i = 0; i <10; i++) {
            System.out.println("我是第二个方法");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}


class LockThread extends Thread {
    @Override
    public void run() {

    }
}

class TestThread implements Runnable {

    TestThread(String name){

        this.name = name;
        }
        String name;

      public void run() {
        while (tickets > 0) {
            tickets--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) tickets) {
                System.out.println(Thread.currentThread().getName() + "卖出一张票  " + "还剩" + tickets + "张票");
            }
        }
    }
}
