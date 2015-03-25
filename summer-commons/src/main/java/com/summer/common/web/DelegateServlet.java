package com.summer.common.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Allen on 2015/3/17.
 */
public class DelegateServlet extends GenericServlet {
    private String  targetBean;    //当前客户端请求的Servlet名字
    private Servlet proxy;         //代理Servlet

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        proxy.service(req, res);
    }

    @Override
    public void init() throws ServletException{
        super.init();
        WebApplicationContext wac =
                WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()); //初始化Spring容器
        this.targetBean = getServletName();
        this.proxy = (Servlet) wac.getBean(targetBean);//调用ServletBean
        proxy.init(getServletConfig());
    }
}
