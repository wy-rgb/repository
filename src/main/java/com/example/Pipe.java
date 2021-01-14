package com.example;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {
    public static void main(String[] args) throws InterruptedException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(()->{
            try {
                byte[] b = new byte[1024];
                System.out.println("接收方~~~");
                int read = pis.read(b);
                System.out.println(new String(b,0,read));
                Thread.sleep(5000);
                System.out.println("睡醒了");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(()->{
            try {
                System.out.println("发送方~~~");
                pos.write("你好~！".getBytes());
                t1.join();
                System.out.println("返回了！~~~");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }

}
