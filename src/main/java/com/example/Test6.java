package com.example;

import java.awt.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Test6 {



    public static void main(String[] args) throws InterruptedException {



        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(()->{

                lock.tryLock();
            Condition condition = lock.newCondition();

            lock.unlock();

        });

        new Thread(()->{

            System.out.println(Thread.currentThread().getName() + "需要锁");

            lock.lock();
            t1.interrupt();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
            lock.unlock();
        }).start();
        Thread.sleep(1000);
        t1.start();


    }


}
