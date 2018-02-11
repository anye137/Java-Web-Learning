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
		
		//请求来源网址
		String referer=req.getHeader("referer");
		
		//如果请求不是来自本站
		if(referer==null||!referer.contains(req.getServerName())){
			req.getRequestDispatcher("/images/error.jpg").forward(req, response);
		}
		else{  //如果来自本站
			chain.doFilter(req, response);
		}
		
	}

	
	

}
