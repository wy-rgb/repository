package com.example;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask {

    int n;

    Task(int n){
        this.n = n;
    }
    @Override
    protected Integer compute() {

        if( n == 1){
            return n;
        }

        Task task = new Task(n-1);
        task.fork();

        int m = (Integer) task.join();
        int result = n + m;
        return result;
    }
}
