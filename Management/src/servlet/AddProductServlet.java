package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet{

    private ProductService ps = new ProductService();
    public void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        //设置编码
        request.setCharacterEncoding("utf-8");
        
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
       
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        
        //增加商品
        ps.addProduct(p);
        
        response.sendRedirect("listProduct");
    }
}
