package com.anye137.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


public class AntiStealingLinkFilter implements Filter {
    
    public AntiStealingLinkFilter() {}	
    public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		
		//������Դ��ַ
		String referer=req.getHeader("referer");
		
		//������������Ա�վ
		if(referer==null||!referer.contains(req.getServerName())){
			req.getRequestDispatcher("/images/error.jpg").forward(req, response);
		}
		else{  //������Ա�վ
			chain.doFilter(req, response);
		}
		
	}

	
	

}
