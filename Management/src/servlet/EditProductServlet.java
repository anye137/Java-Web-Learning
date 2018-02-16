package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet{

    private ProductService ps = new ProductService();
    public void service(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        //根据id查找商品
        Product p = ps.findProductById(id);
        
        request.setAttribute("product", p);      
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }
}
