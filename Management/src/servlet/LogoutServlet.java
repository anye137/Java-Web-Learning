package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

    public void service(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        
        request.getSession().removeAttribute("user");
        response.sendRedirect("loginOrRegister.jsp");
    }
}
