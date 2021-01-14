package com.example;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Thread.enumerate;
import static java.lang.Thread.sleep;

public class Test5 {

    byte[] b = new byte[1024*4];

    Object obj;

    public static void main(String[] args) throws IOException {

            ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
            List<SoftReference<byte[]>> list = new ArrayList<>();

            for(int i = 0;i < 5;i++){
                SoftReference<byte[]> ref = new SoftReference<>(new byte[1024*4],queue);
                list.add(ref);
            }

            //从队列中获取无用的软引用对象
            Reference<? extends byte[]> poll = queue.poll();
            while(poll != null){
                list.remove(poll);
                poll = queue.poll();
            }

            //输出去除无用引用之后的对象
            for(SoftReference<byte[]> reference : list){
                System.out.println(reference.get());
            }
        }

}
