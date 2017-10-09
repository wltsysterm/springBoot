package com.neo.filter;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * 实现javax.servlet.Filter,覆盖其三个方法
 * @author Administrator
 *
 */
@WebFilter(filterName="customFilter",urlPatterns="/*")
public class CustomFilter implements Filter{

    @Override
    public void destroy() {
        System.out.println("CustomFilter过滤器销毁");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("CustomFilter指定过滤器操作......");
        //执行操作后必须doFilter
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("CustomFilter初始化......");
    }
}
