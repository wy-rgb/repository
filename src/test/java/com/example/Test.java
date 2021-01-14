package com.example;

public class Test {

    public static void main(String[] args) {

        System.out.println("?????");
       // System.out.println(quickMulti(10,1));
    }

    public static int quickMulti(int A, int B) {
        int ans = 0;
        System.out.println("+"+B);

        for(; B>0 ; B>>=1){
            if((B&1) > 0){
                ans += A;
            }
            A<<=1;
        }
        return ans;
    }

}
