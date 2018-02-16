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
        
        //设置编码
        request.setCharacterEncoding("utf-8");
        
        
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        
        //根据用户名和密码查找用户
        User u = us.findUser(name, pwd);
        
        //如果找不到
        if(u==null){
            //在request中设置error属性，然后跳转到登录界面，登录界面根据error属性弹出登录失败对话框
            request.getSession().setAttribute("error", "用户名或者密码错误");
            response.sendRedirect("loginOrRegister.jsp");
        }
        //如果找到对应用户
        else{
            //设置session的user属性，并跳转到展示商品的界面，商品界面根据user属性会展示登录用户的信息
            request.getSession().setAttribute("user", u);
            response.sendRedirect("listProduct");
        }
    }
}
