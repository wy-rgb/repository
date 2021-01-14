package com.example;


import java.io.*;
import java.util.List;

public class Test7{


    public static void main(String[] args) throws ClassNotFoundException, IOException {

        String file = "E:\\data\\result\\motion_svm.txt";
        int count = 0;

        //List<Double[]> data = getData(file);
/*
        for(int i = 0;i < data.size();i++){
            Double[] d = data.get(i);
            double label = d[1] > 0.5 ? 1.0 : 0.0;
            if(d[0] == label){
                count++;
            }
        }
       // String a = "aaabb";
        System.out.println(count);*/



    }

    public static void getData(String fileName) throws IOException {
     //   List<Double[]> list = new ArrayList<>();
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        while((line = br.readLine()) != null){
            String[] str = line.split(" ");
            int index = str.length;
            Double[] d = new Double[index];
            for(int i = 0;i < index;i++){
                d[i] = Double.parseDouble(str[i]);
            }
        //    list.add(d);
        }
        //return list;
    }

}
