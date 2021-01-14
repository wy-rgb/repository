package com.example;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.HashSet;

public class Sort {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        //quickSort(arr,0,arr.length-1);
        bubbleSort(arr);
        for(int i : arr){
            System.out.print(i+ ",");
        }

    }

    public static void bubbleSort(int[] n){
        int l = n.length;
        boolean flag = true;
        for(int i = 0;i < l;i++){
            System.out.println("计数使用..");
            for(int j = 1;j < l-i;j++){
                if(n[j-1] > n[j]){
                    flag = false;
                    int temp = n[j-1];
                    n[j-1] = n[j];
                    n[j] = temp;
                }
            }
            if(flag == true){
                break;
            }
            flag = true;
        }

    }

    public static void quickSort(int[] n,int low,int high){
        if(low < high){
            int index = getIndex(n,low,high);
            quickSort(n,low,index-1);
            quickSort(n,index+1,high);
        }
    }

    public static int getIndex(int[] n,int low,int high){
        int temp = n[low];
        while(low < high){
            while(low < high && n[high] >= temp){
                high--;
            }
            n[low++] = n[high];
            while(low < high && n[low] <= temp){
                low++;
            }
            n[high--] = n[low];
        }
        n[low] = temp;
        return low;
    }
}

