package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet{

    private ProductService ps = new ProductService();
    public void service(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        
        ps.deleteProduct(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("listProduct");
    }
}
