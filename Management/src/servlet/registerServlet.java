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
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        User u = new User();
        u.setName(name);
        u.setPwd(pwd);
        u = us.addUser(u);
        if(u!=null){
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getPwd());
            request.getSession().setAttribute("user", u);
            response.sendRedirect("listProduct");
        }
        else{
            request.getSession().setAttribute("error", "×¢²áÊ§°Ü");
            response.sendRedirect("login.jsp");
        }
        
    }
    
}
