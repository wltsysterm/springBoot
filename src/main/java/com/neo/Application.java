package com.neo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
* @EnableAutoConfiguration:spring boot的注解，一般只用于主类，
* 是无xml配置启动的关键部分,明确指定了扫描包的路径为其修饰的主类的包（这也就是为什么主类要放在根包路径下的原因）
* 
* @ComponentScan 进行包的扫描，扫描路径由@EnableAutoConfiguration指定了
* 
* 主类要位于根包路径下，方便之后的扫描(We generally recommend that you locate your main application class in a root package above other classes.)
* 
    主类要位于根包路径下（例如，com.xxx.firstboot），这是推荐做法，方便扫描
    每一个jar（即每一个子项目）都要有一个主方法，用于启动该jar（也就是一个微服务）
    在主类上添加注解@SpringBootApplication，该注解相当于添加了如下三个注解
        @Configuration：该注解指明该类由spring容器管理
        @EnableAutoConfiguration：该注解是无xml配置启动的关键部分
        @ComponentScan：该注解指定扫描包（如果主类不是位于根路径下，这里需要指定扫描路径），类似于spring的包扫描注解

*/
@SpringBootApplication        //same as @Configuration+@EnableAutoConfiguration+@ComponentScan
@ServletComponentScan//监听器 过滤器启用开关
@MapperScan("com.neo.mapper")
public class Application {
    /**
     * 修改DispatcherServlet默认配置
     * @param dispatcherServlet
     */
    @Bean //@Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("/api/*");
        registration.addUrlMappings("/wlt/*");
        registration.addUrlMappings("/*");
//        registration.addUrlMappings("*.json");
        return registration;
    }
//    /**
//     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
//     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new MyServlet(), "/xs/*");// ServletName默认值为首字母小写，即myServlet
//    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
