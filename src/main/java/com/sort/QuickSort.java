package com.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class QuickSort {


        public static void main(String[] args) {
           /* int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
            quickSort(arr,0,arr.length-1);
            for(int i : arr){
                System.out.print(i+ " ");
            }*/

            String s = "aaa";

            ArrayList<Integer> list = new ArrayList<>();

            list.add(1);
            System.out.println(-1>>31);
            
        }



        public static void quickSort(int[] n,int low,int high){
            System.out.println("-------------------");
            for(int i : n){
                System.out.print(i+ " ");
            }
            System.out.println("======================");
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
                if(n[high] < temp) n[low++] = n[high];
                while(low < high && n[low] < temp){
                    low++;
                }
                if(n[low] >= temp) n[high--] = n[low];
            }
            n[low] = temp;
            return low;
        }
    }

