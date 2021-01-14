package com.example;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TwinsLock {
    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if(count <= 0){
                throw new IllegalArgumentException();
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for(;;){
                int current = getState();
                int newCount = current - arg;
                if(newCount >= 0 && compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for(;;){
                int current = getState();
                int newCount = current + arg;
                if(compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

    public void lock(){
        sync.tryAcquireShared(1);
    }

    public void unLock(){
        sync.tryReleaseShared(1);
    }
}
