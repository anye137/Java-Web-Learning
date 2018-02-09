package com.anye137.test;
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        
        HttpSession session = request.getSession();
        session.setAttribute("name", request.getParameter("name"));
        response.sendRedirect("jsp/afterLogin.jsp");
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
}  