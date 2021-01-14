package com.example;

import java.lang.Math;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Test {

    public static void main(String[] args) {
        double a1 = 34;
        double a2 = 108.83154076241186;
        double b1 = 35;
        double b2 = 108.83154076241186;
        double c = distance(a1,a2,b1,b2);
        System.out.println(c);
    }

    public static double distance(double a1,double a2,double b1,double b2){
        double c = sin(a1)*sin(b1)*cos(a2-b2) + cos(a1)*cos(b1);

        double d  = 6371.004*Math.acos(c)*Math.PI/180;
        return d;
    }
}



