package service;
import domain.Product;

import java.util.List;

import dao.ProductDAO;
public class ProductService {
    private ProductDAO pdao = new ProductDAO();
    public int addProduct(Product p){
        return pdao.addProduct(p);
    }
    public int deleteProduct(int id){
        return pdao.deleteProduct(id);
    }
    public int updateProduct(Product p){
        return pdao.updateProduct(p);
    }
    public List<Product> listProduct(){
        return pdao.listProduct();
    }
    public Product findProductById(int id){
        return pdao.findProductById(id);
    }
}
