package dao;
import domain.User;
import java.sql.DriverManager;
import java.sql.*;
public class UserDAO {
  
    //封装获取数据库连接的方法
    public Connection getConnection() throws SQLException{
      
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());               
        Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/management?characterEncoding=utf-8",
          "root","admin");
        return conn;
    } 
  
    //增加用户，并返回新增的用户对象
    public User addUser(User u){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        User user = null;
        String sql = "insert into user (name,pwd) values (?,?)";
        try{
            conn = getConnection();
            //第二个参数表明支持获取新增数据的id
            preStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          
            preStmt.setString(1, u.getName());
            preStmt.setString(2, u.getPwd());
            
            int result = preStmt.executeUpdate();
          
            if(result==1){
                rs = preStmt.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    user = new User();
                    user.setId(id);
                    user.setName(u.getName());
                    user.setPwd(u.getPwd());
                }
            }
            if(conn!=null)
                conn.close();
            if(preStmt!=null)
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
  
    //根据用户名和密码查找用户
    public User findUser(String name,String pwd){
        User u = null;
        Connection conn =null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        String sql = "select * from user where name=? and pwd=?";
        try{
            conn = getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, name);
            preStmt.setString(2, pwd);
            
            rs = preStmt.executeQuery();
            if(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(name);
                u.setPwd(pwd);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return u;
    }
}