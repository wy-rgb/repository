package com.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
    import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 implements MethodInterceptor {
    private Object target;

    Test2(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类代理对象
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //增强方法
        method.invoke(target,objects);
        return null;
    }

    public static void main(String[] args) {
        double b = 0.7;
        System.out.println((int)b);
    }
}
