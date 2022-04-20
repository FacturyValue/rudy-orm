package com.springstack.demo.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author heyahui
 * 字符编码过滤器
 * @WebFilter+@ServletComponentScan 在 MyFilter上添加@WebFilter注解，并在启动类上增加@ServletComponentScan("com.zhengxl.filterdemo.filter")注解，
 * 参数就是Filter所在的包路径，相当于告诉 SpringBoot，去哪里扫描 Filter
 * @WebFilter+@ServletComponentScan 注解方式支持对 Filter 匹配指定URL，但是不支持指定 Filter 的执行顺序。
 */

//@WebFilter(urlPatterns = "/hello",filterName = "MyCharacterEncodingFilter")
public class MyCharacterEncodingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        //request.setCharacterEncoding("ISO-8859-1");
        response.setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("ISO-8859-1");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
