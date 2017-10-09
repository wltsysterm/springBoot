package com.neo.interceptor.configure;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @WebApplicationInitializer 用来配置Servlet3.0的接口 ,也就代替了web.xml ,里面配置的内容和xml配置基本一致 ,部署在tomcat时容器会自动寻找并加载这个实现
 * <p>
 * SpringBoot方式启动的话 ,可以通过配置类(类里定义servlet bean ,然后import到Application)
 */
@Configuration
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(MvcConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/api/");
        servlet.setLoadOnStartup(1);
    }
}