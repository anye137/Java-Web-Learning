package com.anye137.test;
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/testEncoding")
public class TestEncoding extends HttpServlet {  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      //�����Ϣ�������Ƿ�����
        response.getWriter().write("Hello, �������룡��������Ϊ�� "+request.getParameter("name"));                 
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
}  