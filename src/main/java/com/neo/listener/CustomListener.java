package com.neo.listener;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 实现ServletContextListener，覆盖其两个方法
 * @author Administrator
 *
 */
@WebListener
public class CustomListener implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent servletContext) {
        System.out.println("servletContext销毁......");

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContext) {
        System.out.println("servletContext初始化......");
    }

}