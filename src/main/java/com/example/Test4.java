package com.example;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;

public class Test4 {

    public static void main(String[] args) throws IOException {
       File file = new File("E:\\test.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        File file1 = new File("E:\\t.txt");
        FileOutputStream fos = new FileOutputStream(file1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        List<String> list = new ArrayList<>();
        String line = null;
        while((line = br.readLine()) != null){
            if(line.contains("geo") || line.contains("位置")) {
                String geo = line.replaceAll("geo:", "");
                geo = geo.replaceAll("位置:", "");
                geo = geo.replaceAll(","," ");
                list.add(geo);
            }
        }
        System.out.println(list.size());
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
            bw.write(list.get(i));
            bw.newLine();
        }
        bw.flush();

    }

}
