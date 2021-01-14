package com.tomcat;

public class UrlUtil {
    public UrlBean getString(String info){
        UrlBean bean = null;
        int tag1 = info.indexOf(":");
        int tag2 = info.lastIndexOf(":");
        int tag3 = info.indexOf("/",tag2);
        int tag4 = info.lastIndexOf("/");
        int tag5 = info.indexOf("?");
        int tag6 = info.lastIndexOf(".");

        String protocol = info.substring(0,tag1);
        String host = info.substring(tag1+3,tag2);
        String port = info.substring(tag2+1,tag3);
        String path = info.substring(tag3+2,tag4);
        String fileName = info.substring(tag4+1,tag6);
        String parameter = info.substring(tag5+1,info.trim().length());

        if (host != null && path != null && fileName != null) {
            if (protocol == null) {
                protocol = "http";
            }
            if (port == null) {
                port = "8080";
            }
            bean = new UrlBean(protocol, host, port, path, fileName, parameter);
            return bean;
        }

        return bean;
    }
}
