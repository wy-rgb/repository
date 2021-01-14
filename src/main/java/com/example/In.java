package com.example;

public interface In {
    public int k = 10;
    int i = 10;
    static int j = 20;

    private void pa2() {
        System.out.println("hh");
    }                  //私有
    private static void  pa4(){}            //私有静态
    default void da2() { }                  //默认
    public abstract void pua1();            //public抽象方法
    public static void pua4() {

    }
    static void t(){

    }

    default void test(){
        pa2();
    }
}
