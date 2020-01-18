package com.niepengfei.springboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * <p>
 * 模拟spring boot
 * </p>
 * @author Jack
 * @version 1.0.0
 */
public class SpringApplication {

    public static void run(){
        try{
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(9090);
            File file = new File(System.getProperty("java.io.tmpdir"));
            tomcat.addWebapp("/",file.getAbsolutePath());
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}


