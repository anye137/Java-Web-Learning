package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductService;
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet{
    private ProductService ps = new ProductService();
    @Override
    public void service(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        List<Product> plist = ps.listProduct();
        request.setAttribute("plist", plist);
        
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);
    }
}
