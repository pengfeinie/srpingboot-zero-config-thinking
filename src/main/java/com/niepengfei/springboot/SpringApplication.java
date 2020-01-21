package com.niepengfei.springboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration;
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
            //File file = new File(System.getProperty("java.io.tmpdir"));


            Server server = tomcat.getServer();
            Service service = server.findService("Tomcat");

            Connector connector = new Connector();
            connector.setPort(9090);

            Engine engine = new StandardEngine();
            engine.setDefaultHost("localhost");

            Host host = new StandardHost();
            host.setName("localhost");

            String contextPath = "";
            Context context = new StandardContext();
            context.setPath(contextPath);
            context.addLifecycleListener(new Tomcat.FixContextListener());

            host.addChild(context);
            engine.addChild(host);

            service.setContainer(engine);
            service.addConnector(connector);
            //tomcat.addWebapp("/",file.getAbsolutePath());
            AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
            ac.register(AppConfig.class);
            DispatcherServlet servlet = new DispatcherServlet(ac);
            Wrapper registration = tomcat.addServlet(contextPath,"app", servlet);
            //ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
            registration.setLoadOnStartup(1);
            registration.addMapping("/");

            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}


