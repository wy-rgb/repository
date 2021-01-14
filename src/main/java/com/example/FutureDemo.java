package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;

public class FutureDemo {
    public static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            Logger.getGlobal().info("睡眠中");
            Thread.sleep(7000);
            System.out.println("第er次睡眠");
            return "call return" + Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger.getGlobal().setLevel(Level.ALL);
        FutureDemo demo = new FutureDemo();
        demo.testFuture();
    }

    public void testFuture() throws ExecutionException, InterruptedException {

        List<Future<String>> list = new ArrayList<>();
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0;i < 10;i++){
            Logger.getGlobal().info("提交任务");

            list.add(service.submit(new Task()));
        }

            for(Future<String> future : list){
                if(!future.isDone()) System.out.println("资源还没有准备好");
                System.out.println(future.get());
            }
        Logger.getGlobal().info("结束");
            service.shutdown();

    }
}
