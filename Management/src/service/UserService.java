package service;
import dao.UserDAO;
import domain.User;
public class UserService {

    private UserDAO udao = new UserDAO();
    
    //�����û�
    public User addUser(User u){
        return udao.addUser(u);        
    }
    
    //�����û�������������û�
    public User findUser(String name,String pwd){
        return udao.findUser(name, pwd);
    }
}
