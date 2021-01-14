package com.example;

import java.util.*;
import java.io.*;

public class Test3 {

    public static void main(String[] args) throws IOException {

        for(int i = 1;i <= 90;i++){
            List<Double[]> list = new ArrayList();
            String file = "E:\\data\\user" +i+ "\\data\\all.csv";
            List<Double[]> data1 = getData("E:\\data\\user"+ i+ "\\data\\NormaltouchFeatures.csv");
            List<Double[]> data2 = getData("E:\\data\\user" + i + "\\data\\normalMotion.csv");

            for(int j = 0;j < data1.size();j++){
                Double[] b = new Double[data1.get(0).length + data2.get(0).length];
                for(int k = 0;k < data1.get(0).length;k++){
                    b[k] = data1.get(j)[k];
                }
                for(int k = 0;k < data2.get(0).length;k++){
                    b[data1.get(0).length+k] = data2.get(j)[k];
                }
                list.add(b);
            }
            writeData(list,file);
        }



    }

    public static List<Double[]> getData(String fileName) throws IOException {
        List<Double[]> list = new ArrayList<>();
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        while((line = br.readLine()) != null){
            String[] str = line.split(",");
            int index = str.length;
            Double[] d = new Double[index];
            for(int i = 0;i < index;i++){
                d[i] = Double.parseDouble(str[i]);
            }
            list.add(d);
        }
        return list;
    }

    public static void writeData(List<Double[]> d,String fileName) throws IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        for(int i = 0;i < d.size();i++){
            String str = "";
            for(int j = 0;j < d.get(0).length;j++){
                str = str + d.get(i)[j] + ",";
            }
            writer.write(str.substring(0,str.length()-1));
            writer.newLine();
        }
        writer.close();
        fos.close();
    }
}
