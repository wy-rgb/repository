package com.tomcat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {

    private static int port = 5253;
    private static UrlUtil util = new UrlUtil();

    public static void main(String[] args) {
        System.out.println("tomcat is running...");

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket client = serverSocket.accept();
                InputStream is = client.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String info = null;

                String infoLine = null;

                while((infoLine = br.readLine()) != null){
                    info += infoLine;
                }

                UrlBean url = util.getString(info);

                if(url != null){
                    String path=url.getPath();
                    String className = url.getFileName();
                    String methodName = url.getParameter().trim();

                    ClassLoader classLoader = ClassLoader.getSystemClassLoader();

                    classLoader.loadClass(path + "." + className);
                    Class<?> getclass=Class.forName(path+"."+className);
                    Method method=getclass.getMethod(methodName, null);
                    method.invoke(getclass.newInstance(), null);
                }

            }



        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
