package com.example;
import com.example.Job;

public interface ThreadPool{

    void execute(Job job);
    void shutDown();
    void addWorker(int num);
    void removeWorker();
    int getJobSize();
}
