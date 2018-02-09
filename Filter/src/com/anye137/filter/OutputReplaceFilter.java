package com.anye137.filter;
import java.io.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

@WebFilter(
    filterName="outputReplaceFilter", 
    urlPatterns="/*",
    initParams={@WebInitParam(name="file",value="/WEB-INF/sensitive.properties")}  
)

public class OutputReplaceFilter implements Filter {
    
    //�Ƿ��ʡ����д������� properties�ļ���
    private Properties pp = new Properties();
    
    public OutputReplaceFilter() {}
      
    public void init(FilterConfig config) throws ServletException {
        //properties�ļ���
        String file = config.getInitParameter("file");
        //�ļ�λ��
        String realPath = config.getServletContext().getRealPath(file);
        
        try{
            //���properties�ļ���ISO-8859-1���룬����ֱ������䣺pp.load(new FileInputStream(realPath));
            //����ļ���utf-8���룬�Ұ������ģ�������������
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(realPath));    
            pp.load(new InputStreamReader(in, "utf-8"));                       
        }catch(IOException e){}
    }
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("replace");
	    HttpServletResponse res = (HttpServletResponse)response;
	    //ʹ���Զ���response
	    OutputReplaceResponse orr = new OutputReplaceResponse(res);
	    
	    //doFilter��ʹ���Զ��� response orr
	    chain.doFilter(request, orr);
	    
	    //�õ�response�������
	    String output = orr.getCharArrayWriter().toString();
	    
	    //�����������д�
	    for(Object obj: pp.keySet()){
	        String key = (String)obj;
	        //�滻���д�
	        output = output.replace(key, pp.getProperty(key));
	    }
	    
	    //ͨ��ԭ����response��getWriter()�������
	    PrintWriter out = response.getWriter();
	    //����������ͻ���
	    out.write(output);		
	}
	
	class OutputReplaceResponse extends HttpServletResponseWrapper{
        
	    //�ַ�����Writer
	    private CharArrayWriter caw=new CharArrayWriter();
        public OutputReplaceResponse(HttpServletResponse response) {
            super(response);          
        }
        @Override
        public PrintWriter getWriter() throws IOException{
            //�����ַ�����Writer����������
            return new PrintWriter(caw);
        }
        
        public CharArrayWriter getCharArrayWriter(){
            return caw;
        }	    
	}
	
}
