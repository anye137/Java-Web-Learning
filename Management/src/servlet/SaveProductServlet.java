package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

@WebServlet("/saveProduct")
public class SaveProductServlet extends HttpServlet{

    private ProductService ps = new ProductService();
    public void service(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        //System.out.println(request.getParameter("id"));
        //System.out.println(request.getParameter("name"));
        //System.out.println(request.getParameter("price"));
        
        Product p = new Product();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        ps.updateProduct(p);
        
        response.sendRedirect("listProduct");
    }
    
}
