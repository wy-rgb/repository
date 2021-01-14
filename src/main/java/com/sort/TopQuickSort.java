package com.sort;

import java.awt.desktop.OpenURIEvent;
import java.io.*;
import java.nio.file.Path;
import java.util.Random;

public class TopQuickSort{

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\JaveSpace\\maven\\src\\main\\resources\\output\\t.txt");
        FileOutputStream outputStream = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

        int number = 10000000;

        int k =100;

        int range = 10000001;

        int[] array = new int[number];

        Random random = new Random();

        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt(range);
            bw.write(String.valueOf(array[i]));
            bw.newLine();

        }
        bw.close();

        long t1 = System.currentTimeMillis();

        TopQuickSort(array,0,number-1,k);

        long t2 = System.currentTimeMillis();

        System.out.println("The total execution time " +
                "of quicksort based method is " + (t2 - t1) +" millisecond!");

        // print out the top k largest values in the top array
        System.out.println("The top "+ k + " largest values are:");
        for (int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 从大规模的数组中找到最大的K位数
     * @param arr
     * @param low
     * @param high
     * @param k
     */
    public static void TopQuickSort(int[] arr,int low,int high,int k){
        if(high - low == k-1) return;
        int index = getIndex(arr, low, high);
        if(high - low > k-1){
            TopQuickSort(arr,low,index-1,k);
        }
        if(index - low < k-1){
            TopQuickSort(arr,index+1,high,k - (high-low +1));
        }

    }

    public static int getIndex(int[] arr,int low,int high){

        int temp = arr[low];

        while(low < high){
            while(low < high && arr[high] >= temp){
                high--;
            }
            if(arr[high] < temp) arr[low++] = arr[high];
            while(low < high && arr[low] < temp){
                low++;
            }
            if(arr[low] >= temp) arr[high--] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
