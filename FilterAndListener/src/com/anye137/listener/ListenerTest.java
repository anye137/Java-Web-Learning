package com.anye137.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebListener;;

@WebListener
public class ListenerTest implements HttpSessionListener,
        ServletContextListener, ServletRequestListener{
    
    @Override
    public void contextInitialized(ServletContextEvent e) {
        //加载servlet上下文时被调用
        ServletContext context = e.getServletContext();
        System.out.println("启动context："+context.getContextPath());
    }

 
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        ServletContext context = e.getServletContext();
        System.out.println("关闭context："+context.getContextPath());
        
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        //创建session时被调用
        HttpSession session = e.getSession();       
        System.out.println("创建session，id为："+session.getId());
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        //销毁session前被调用
        HttpSession session = e.getSession();
        System.out.println("销毁session，id为："+session.getId());
        
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent e) {
        //创建requests时调用
        HttpServletRequest request = (HttpServletRequest)e.getServletRequest();
        String uri = request.getRequestURI(); 
        if(request.getQueryString()!=null)
            uri = uri+"?"+request.getQueryString();
        request.setAttribute("dateCreated", System.currentTimeMillis());
        System.out.println("IP "+request.getRemoteAddr()+" 请求 "+uri);
        
    }
    @Override
    public void requestDestroyed(ServletRequestEvent e) {
        //销毁request时被调用
        HttpServletRequest request = (HttpServletRequest)e.getServletRequest();
        long time = System.currentTimeMillis()-(Long)request.getAttribute("dateCreated");    
        System.out.println("IP "+request.getRemoteAddr()+"请求处理结束，用时"+time+"毫秒");        
    }

}
