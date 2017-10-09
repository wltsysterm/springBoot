package com.neo.listener;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 实现HttpSessionListener接口，监视session的动态
 * @author Administrator
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent session) {
        System.out.println("session创建成功......");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent session) {
        System.out.println("session销毁......");
    }
}
