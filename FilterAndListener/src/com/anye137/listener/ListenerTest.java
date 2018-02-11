package com.anye137.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebListener;;

@WebListener
public class ListenerTest implements HttpSessionListener,
        ServletContextListener, ServletRequestListener{
    
    @Override
    public void contextInitialized(ServletContextEvent e) {
        //����servlet������ʱ������
        ServletContext context = e.getServletContext();
        System.out.println("����context��"+context.getContextPath());
    }

 
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        ServletContext context = e.getServletContext();
        System.out.println("�ر�context��"+context.getContextPath());
        
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        //����sessionʱ������
        HttpSession session = e.getSession();       
        System.out.println("����session��idΪ��"+session.getId());
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        //����sessionǰ������
        HttpSession session = e.getSession();
        System.out.println("����session��idΪ��"+session.getId());
        
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent e) {
        //����requestsʱ����
        HttpServletRequest request = (HttpServletRequest)e.getServletRequest();
        String uri = request.getRequestURI(); 
        if(request.getQueryString()!=null)
            uri = uri+"?"+request.getQueryString();
        request.setAttribute("dateCreated", System.currentTimeMillis());
        System.out.println("IP "+request.getRemoteAddr()+" ���� "+uri);
        
    }
    @Override
    public void requestDestroyed(ServletRequestEvent e) {
        //����requestʱ������
        HttpServletRequest request = (HttpServletRequest)e.getServletRequest();
        long time = System.currentTimeMillis()-(Long)request.getAttribute("dateCreated");    
        System.out.println("IP "+request.getRemoteAddr()+"�������������ʱ"+time+"����");        
    }

}
