package service;
import dao.UserDAO;
import domain.User;
public class UserService {

    private UserDAO udao = new UserDAO();
    
    //新增用户
    public User addUser(User u){
        return udao.addUser(u);        
    }
    
    //根据用户名和密码查找用户
    public User findUser(String name,String pwd){
        return udao.findUser(name, pwd);
    }
}
