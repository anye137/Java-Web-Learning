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
    
    //非法词、敏感词配置在 properties文件中
    private Properties pp = new Properties();
    
    public OutputReplaceFilter() {}
      
    public void init(FilterConfig config) throws ServletException {
        //properties文件名
        String file = config.getInitParameter("file");
        //文件位置
        String realPath = config.getServletContext().getRealPath(file);
        
        try{
            //如果properties文件是ISO-8859-1编码，可以直接用这句：pp.load(new FileInputStream(realPath));
            //如果文件是utf-8编码，且包含中文，需用下面两句
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(realPath));    
            pp.load(new InputStreamReader(in, "utf-8"));                       
        }catch(IOException e){}
    }
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("replace");
	    HttpServletResponse res = (HttpServletResponse)response;
	    //使用自定义response
	    OutputReplaceResponse orr = new OutputReplaceResponse(res);
	    
	    //doFilter，使用自定义 response orr
	    chain.doFilter(request, orr);
	    
	    //得到response输出内容
	    String output = orr.getCharArrayWriter().toString();
	    
	    //遍历所有敏感词
	    for(Object obj: pp.keySet()){
	        String key = (String)obj;
	        //替换敏感词
	        output = output.replace(key, pp.getProperty(key));
	    }
	    
	    //通过原来的response的getWriter()方法输出
	    PrintWriter out = response.getWriter();
	    //真正输出到客户端
	    out.write(output);		
	}
	
	class OutputReplaceResponse extends HttpServletResponseWrapper{
        
	    //字符数组Writer
	    private CharArrayWriter caw=new CharArrayWriter();
        public OutputReplaceResponse(HttpServletResponse response) {
            super(response);          
        }
        @Override
        public PrintWriter getWriter() throws IOException{
            //返回字符数组Writer，缓存内容
            return new PrintWriter(caw);
        }
        
        public CharArrayWriter getCharArrayWriter(){
            return caw;
        }	    
	}
	
}
