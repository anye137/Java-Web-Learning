package com.anye137.listener;
import java.util.HashMap;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {
    
    //储存目前登录的用户,key为userName,value为session
    HashMap<String, HttpSession> map = new HashMap<>();
    
    @Override
    //添加session属性时被调用
    public void attributeAdded(HttpSessionBindingEvent e){        
        //新添加的属性
        String attrName = e.getName();
        
        if(attrName.equals("userName")){
            String attrValue = (String)e.getValue();
            //若map中存在该用户
            if(map.get(attrValue)!=null){
                //将以前的登录失效
                HttpSession session = map.get(attrValue);               
                session.removeAttribute("userName");                     
            }
            //新用户session存进map 
            map.put(attrValue, e.getSession());
            System.out.println("账号:"+attrValue+",登录");
        }      
    }
    
    @Override
    //删除属性前被调用
    public void attributeRemoved(HttpSessionBindingEvent e){
        //被删除的属性
        String attrName = e.getName();       
        if(attrName.equals("userName")){
            String attrValue = (String) e.getValue();
            map.remove(attrValue);
            System.out.println("账号："+attrValue+",注销");
        }
    }
    
    @Override
    //修改属性时被调用
    public void attributeReplaced(HttpSessionBindingEvent e){
        String attrName = e.getName();
        //没有注销的情况下，用另一个账号登录
        if(attrName.equals("userName")){
            String oldValue = (String) e.getValue();
            String newValue = (String) e.getSession().getAttribute("userName");
            //注意要判断新值旧值是否相等
            if(!oldValue.equals(newValue)){
                //检查新登录的账号是否在别的机器上登录过
                if(map.get(newValue)!=null){                
                    HttpSession session = map.get(oldValue);
                    session.removeAttribute("userName");               
                    map.remove(oldValue);
                }              
                map.put(newValue, e.getSession());
                System.out.println("原账号："+oldValue+"。被新账号："+newValue+"替代");
            }
            else{
                System.out.println("账号："+oldValue+",重新登录");
            }
        }
    }
    
}
