package com.anye137.filter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class CharacterEncodingFilter implements Filter {
	
	//�Ƿ����ø�Filter
	private boolean enabled; 
	
	@Override
    public void init(FilterConfig config) throws ServletException {
		// ��ʼ��ʱ�� web.xml�м��ز���		
		enabled = config.getInitParameter("enabled").trim().equalsIgnoreCase("true");
	}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//���������Filter
		if(enabled){
			//����response����	
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			HttpServletRequest req=(HttpServletRequest)request;	
		    //����request����
			EncodingRequest er=new EncodingRequest(req);
		
			chain.doFilter(er, response);
		}
		else
		    chain.doFilter(request, response);
		
	}

	public class EncodingRequest extends HttpServletRequestWrapper{
	    private HttpServletRequest req;
	    public EncodingRequest(HttpServletRequest request){
	        super(request);
	        this.req = request;
	        if(req.getMethod().equalsIgnoreCase("POST")){
	            try {
	                req.setCharacterEncoding("utf-8");
	            } catch (UnsupportedEncodingException e) {                  
	                e.printStackTrace();
	            }
	        }
	    }
	    @Override
	    public String getParameter(String name){
	        String value = req.getParameter(name);
	        if(req.getMethod().equalsIgnoreCase("GET")){
	            try{
	                value = new String(value.getBytes("ISO-8859-1"),"utf-8");
	            }catch(UnsupportedEncodingException e){
	                e.printStackTrace();
	            }
	        }
	        return value;
	    }
	}

}
