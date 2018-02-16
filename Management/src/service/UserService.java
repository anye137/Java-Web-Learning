package service;
import dao.UserDAO;
import domain.User;
public class UserService {

    private UserDAO udao = new UserDAO();
    public User addUser(User u){
        return udao.addUser(u);        
    }
    public User findUser(String name,String pwd){
        return udao.findUser(name, pwd);
    }
}
