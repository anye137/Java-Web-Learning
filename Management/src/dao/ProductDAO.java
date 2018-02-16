package dao;
import domain.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDAO {
    
    //�����ݿ����ӽ��з�װ
    public Connection getConnection() throws SQLException{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/management?characterEncoding=utf-8",
          "root","admin");
        return conn;
    }
    
    //������Ʒ
    public int addProduct(Product p){
        Connection conn = null;
        PreparedStatement preStmt = null;
        int result=0;
        String sql = "insert into product (name,price) values (?,?)";
        try{
            //��ȡ���ݿ�����
            conn = getConnection();
            
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, p.getName());
            preStmt.setFloat(2, p.getPrice());
            
            result = preStmt.executeUpdate();
            
            if(preStmt!=null)
                preStmt.close();
            if(conn!=null)
                conn.close();
                      
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //���ӳɹ��򷵻�1��ʧ������0
        return result;
    }
    
    //ɾ����Ʒ
    public int deleteProduct(int id){
        Connection conn = null;
        PreparedStatement preStmt = null;
        int result=0;
        String sql = "delete from product where id=?";
        try{
            //��ȡ���ݿ�����
            conn = getConnection();
            
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, id);
            
            result = preStmt.executeUpdate();
            
            if(preStmt!=null)
                preStmt.close();
            if(conn!=null)
                conn.close();
                      
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //ɾ���ɹ��򷵻�1��ʧ������0
        return result;
    }
    
    //������Ʒ
    public int updateProduct(Product p){
        Connection conn = null;
        PreparedStatement preStmt = null;
        int result=0;
        String sql = "update product set name=?,price=? where id=?";
        try{
            //��ȡ���ݿ�����
            conn = getConnection();
            
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, p.getName());
            preStmt.setFloat(2, p.getPrice());
            preStmt.setInt(3, p.getId());
            
            result = preStmt.executeUpdate();
            
            if(preStmt!=null)
                preStmt.close();
            if(conn!=null)
                conn.close();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //���³ɹ��򷵻�1��ʧ������0
        return result;
    }
    
    //�г�������Ʒ
    public List<Product> listProduct(){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        String sql = "select * from product";
        List<Product> plist=new ArrayList<>();
        try{
            //��ȡ���ݿ�����
            conn = getConnection();
            
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();          
            
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                plist.add(p);
            }
                    
            if(preStmt!=null)
                preStmt.close();
            if(conn!=null)
                conn.close();
                      
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //���� product list
        return plist;
    }
    
    //����id�ҵ���Ʒ������Ҳ����򷵻�null
    public Product findProductById(int id){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        String sql = "select * from product where id=?";
        Product p=new Product();
        try{
            //��ȡ���ݿ�����
            conn = getConnection();
            
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, id);
            rs = preStmt.executeQuery();          
            
            if(rs.next()){              
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
            }
                    
            if(preStmt!=null)
                preStmt.close();
            if(conn!=null)
                conn.close();
                      
        }catch(SQLException e){
            e.printStackTrace();
        }
        return p;
    }
}
