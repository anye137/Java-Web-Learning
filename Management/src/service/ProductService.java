package service;
import domain.Product;

import java.util.List;

import dao.ProductDAO;
public class ProductService {
    
    private ProductDAO pdao = new ProductDAO();
    
    //增加商品
    public int addProduct(Product p){
        return pdao.addProduct(p);
    }
    //删除商品
    public int deleteProduct(int id){
        return pdao.deleteProduct(id);
    }
    //更新商品
    public int updateProduct(Product p){
        return pdao.updateProduct(p);
    }
    //列出所有商品
    public List<Product> listProduct(){
        return pdao.listProduct();
    }
    //根据id查找商品
    public Product findProductById(int id){
        return pdao.findProductById(id);
    }
}
