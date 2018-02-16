package service;
import domain.Product;

import java.util.List;

import dao.ProductDAO;
public class ProductService {
    
    private ProductDAO pdao = new ProductDAO();
    
    //������Ʒ
    public int addProduct(Product p){
        return pdao.addProduct(p);
    }
    //ɾ����Ʒ
    public int deleteProduct(int id){
        return pdao.deleteProduct(id);
    }
    //������Ʒ
    public int updateProduct(Product p){
        return pdao.updateProduct(p);
    }
    //�г�������Ʒ
    public List<Product> listProduct(){
        return pdao.listProduct();
    }
    //����id������Ʒ
    public Product findProductById(int id){
        return pdao.findProductById(id);
    }
}
