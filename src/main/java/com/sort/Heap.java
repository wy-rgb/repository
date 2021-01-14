package com.sort;

import java.util.LinkedList;

public class Heap {

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        heapify(arr);
        for(int i : arr){
            System.out.print(i+ " ");
        }
        heapSort(arr);
        System.out.println("---");
        for(int i : arr){
            System.out.print(i+ " ");
        }


    }

   public static void heapify(int[] arr){
        for(int i = arr.length/2 - 1;i >= 0;i--){
            down(arr,i,arr.length);
        }
   }

   public static void heapSort(int[] arr){
        for(int i = arr.length-1;i > 0;i--){
            swap(arr,i,0);
            down(arr,0,i);
        }
   }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void down(int[] arr, int i,int len) {

        int temp = arr[i];

        for(int j = 2 * i + 1; j < len;j = 2 * j + 1){
            if(j+1 < len && arr[j+1] > arr[j]){
                j++;
            }

            if(arr[j] > temp){
                arr[i] = arr[j];
                i = j;
            }
        }
        arr[i] = temp;
    }
}
