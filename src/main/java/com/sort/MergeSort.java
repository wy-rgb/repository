package com.sort;

public class MergeSort{

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };

        mergeSort1(arr,0,arr.length-1);

        for(int i : arr){
            System.out.print(i+ " ");
        }
    }
    public static void mergeSort1(int[] arr,int lo,int hi){
        if(lo == hi) return;
        int mid = lo + (hi-lo)/2;
        mergeSort1(arr,lo,mid);
        mergeSort1(arr,mid+1,hi);
        int[] temp = new int[hi-lo+1];
        int i = lo,j = mid+1,cur = 0;
        while(i <= mid && j <=hi){
            temp[cur++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while(i <= mid){
            temp[cur++] = arr[i++];
        }

        while(j <= hi){
            temp[cur++] = arr[j++];
        }

        for(int k = lo;k <= hi;k++){
            arr[k] = temp[k-lo];
        }
    }
}
