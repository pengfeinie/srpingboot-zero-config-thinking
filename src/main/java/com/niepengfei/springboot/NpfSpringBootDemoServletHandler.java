package com.niepengfei.springboot;

import javax.servlet.ServletContext;

/**
 * 2018-2020
 * <p>
 * 测试
 * </p>
 *
 * @author Jack
 * @version 1.0.0
 */
public class NpfSpringBootDemoServletHandler implements SpringBootDemoServletHandler {

    @Override
    public void onStartup(ServletContext servletCxt, String message) {
        System.out.println("NpfSpringBootDemoServletHandler#onStartup 被调用");
    }
}


