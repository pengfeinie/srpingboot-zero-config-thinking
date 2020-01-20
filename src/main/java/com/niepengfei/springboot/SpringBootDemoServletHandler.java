package com.niepengfei.springboot;

import javax.servlet.ServletContext;

/**
 * 2018-2020
 * <p>
 * 让 ServletContainerInitializer 回调处理
 * </p>
 *
 * @author Jack
 * @version 1.0.0
 * @since 1/20/2020
 */
public interface SpringBootDemoServletHandler {

    /**
     * 被 ServletContainerInitializer 的 onStartup 方法调用
     *
     * @param servletCxt servlet 环境
     * @param message 测试的信息
     */
    void onStartup(ServletContext servletCxt,String message);
}
