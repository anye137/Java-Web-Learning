package com.anye137.test;
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/testEncoding")
public class TestEncoding extends HttpServlet {  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      //输出信息，测试是否乱码
        response.getWriter().write("Hello, 测试乱码！输入姓名为： "+request.getParameter("name"));                 
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
}  