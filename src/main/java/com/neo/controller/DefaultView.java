package com.neo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 * spring boot中可以设置默认首页，当输入域名是可以自动跳转到默认指定的网页
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/html/index.html");//直接去获取项目路径下的html文件夹下的index.html文件
//        registry.addViewController("/").setViewName("forward:/index");//这个表示会去寻找mapped url path 为：【/index】的controller映射
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}