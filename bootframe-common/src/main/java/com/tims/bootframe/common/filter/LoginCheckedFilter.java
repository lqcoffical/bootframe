package com.tims.bootframe.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/xxx/*", "/abc/*"})
public class LoginCheckedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // tomcat服务器开始运行的时候会初始化，也可以不重写，调用父类的，这个无所谓
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 拦截后执行doFilter方法

        // 放行到下一个过滤器，没有的话就放行了
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // web程序结束的时候销毁
        Filter.super.destroy();
    }
}
