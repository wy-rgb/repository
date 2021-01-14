package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 构建一个简单的连接池
 */
public class CollectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public CollectionPool(int initialSize){
        if(initialSize > 0){
            for(int i = 0;i < initialSize;i++){
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }
    public void releaseConnection(Connection conn){
        if(conn != null){
            synchronized (pool){
                pool.add(conn);
                pool.notifyAll();
            }
        }
    }

    public Connection getConnection(long miils) throws InterruptedException {
        synchronized (pool){
            if(miils <= 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }
            long future = System.currentTimeMillis() + miils;
            long remain = miils;
            while(pool.isEmpty() && remain > 0){
                pool.wait();
                remain = future - System.currentTimeMillis();
            }
            Connection result = null;
            if(!pool.isEmpty()){
                result = pool.removeFirst();
            }
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException, SQLException {
        CollectionPool pool = new CollectionPool(1);
        for(int i = 0;i < 10;i++){
            new Thread(()->{
                try {
                    Connection connection = pool.getConnection(1000);
                    connection.commit();
                    System.out.println("----");
                    pool.releaseConnection(connection);
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}

