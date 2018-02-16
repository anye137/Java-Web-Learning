package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
 
    private UserService us = new UserService();
    
    public void service(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        User u = us.findUser(name, pwd);
        if(u==null){
            //System.out.println("用户名或密码错误");
            //request.setAttribute("error", "loginError");
            //request.getRequestDispatcher("login.jsp").forward(request, response);
            request.getSession().setAttribute("error", "用户名或者密码错误");
            response.sendRedirect("login.jsp");
        }
        else{
            request.getSession().setAttribute("user", u);
            response.sendRedirect("listProduct");
        }
    }
}
