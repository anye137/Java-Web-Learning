package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet{

    private UserService us = new UserService();
    public void service(HttpServletRequest request,HttpServletResponse response) 
            throws ServletException,IOException{
        
        //ÉèÖÃ±àÂë
        request.setCharacterEncoding("utf-8");
        
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        
        User u = new User();
        u.setName(name);
        u.setPwd(pwd);
        
        //×¢²á
        u = us.addUser(u);
        
        //Èç¹û×¢²á³É¹¦
        if(u!=null){         
            request.getSession().setAttribute("user", u);
            response.sendRedirect("listProduct");
        }
        else{
            request.getSession().setAttribute("error", "×¢²áÊ§°Ü");
            response.sendRedirect("loginOrRegister.jsp");
        }
        
    }
    
}
