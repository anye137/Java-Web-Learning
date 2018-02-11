package com.anye137.filter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(filterName="privilegeFilter",urlPatterns="/jsp/afterLogin.jsp")
public class PrivilegeFilter implements Filter{
    
    public void init(FilterConfig config) throws ServletException{}
    public void destroy(){}
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        
        String name = (String) session.getAttribute("userName");
        if(name==null || name.trim().equals(""))
            res.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
        else
            chain.doFilter(req, response);
    }

 }