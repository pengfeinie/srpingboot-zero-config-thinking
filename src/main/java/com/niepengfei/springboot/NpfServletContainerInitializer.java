package com.niepengfei.springboot;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.WebApplicationInitializer;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2018-2020
 * <p>
 * 实现 servlet 提供的 ServletContainerInitializer 接口
 * </p>
 *
 * @author Jack
 * @version 1.0.0
 */
@HandlesTypes(SpringBootDemoServletHandler.class)
public class NpfServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        List<SpringBootDemoServletHandler> servletHandlers = new LinkedList<>();
        for (Class<?> waiClass : c) {
            if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                    SpringBootDemoServletHandler.class.isAssignableFrom(waiClass)) {
                try {
                    servletHandlers.add((SpringBootDemoServletHandler)
                            ReflectionUtils.accessibleConstructor(waiClass).newInstance());
                } catch (Throwable ex) {
                    throw new ServletException("Failed to instantiate SpringBootDemoServletHandler class", ex);
                }
            }
        }
        AnnotationAwareOrderComparator.sort(servletHandlers);
        for (SpringBootDemoServletHandler initializer : servletHandlers) {
            initializer.onStartup(ctx,"测试消息");
        }
    }
}
