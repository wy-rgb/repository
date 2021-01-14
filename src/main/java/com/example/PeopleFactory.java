package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PeopleFactory{
    static Student student = new Student();
    private static Object People;

    public static People createPeople(){
        return (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello");
                method.invoke(student,null);
                return null;
            }
        });
    }

    public static void main(String[] args) {
        People people = createPeople();
       // people.print();
    }
}
