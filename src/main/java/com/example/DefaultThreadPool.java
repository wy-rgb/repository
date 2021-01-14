package com.example;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import com.example.Job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool implements ThreadPool{

    private static final int MAX_WORKER_NUMBER = 10;
    private static final int DEFAULT_WORKER_NUMBER = 5;
    private static final int MIN_WORKER_NUMBER = 1;

    private LinkedList<Job> jobs = new LinkedList<>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_NUMBER;

    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBER);
    }
    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBER ? MAX_WORKER_NUMBER : num < MIN_WORKER_NUMBER ? MIN_WORKER_NUMBER :num;
        initializeWorkers(workerNum);
    }

    private void initializeWorkers(int workerNum) {
        for(int i = 0;i < workerNum;i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }


    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addFirst(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutDown() {
        for(Worker worker : workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorker(int num) {

    }

    @Override
    public void removeWorker() {

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable {

        private volatile boolean running = true;
        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null){
                    job.run();
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }

    public static void main(String[] args) {
        byte i= 10;
        i+=2;
    }

}
