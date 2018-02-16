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
        
        //���ñ���
        request.setCharacterEncoding("utf-8");
        
        
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        
        //�����û�������������û�
        User u = us.findUser(name, pwd);
        
        //����Ҳ���
        if(u==null){
            //��request������error���ԣ�Ȼ����ת����¼���棬��¼�������error���Ե�����¼ʧ�ܶԻ���
            request.getSession().setAttribute("error", "�û��������������");
            response.sendRedirect("loginOrRegister.jsp");
        }
        //����ҵ���Ӧ�û�
        else{
            //����session��user���ԣ�����ת��չʾ��Ʒ�Ľ��棬��Ʒ�������user���Ի�չʾ��¼�û�����Ϣ
            request.getSession().setAttribute("user", u);
            response.sendRedirect("listProduct");
        }
    }
}
