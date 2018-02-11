package com.anye137.listener;
import java.util.HashMap;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {
    
    //����Ŀǰ��¼���û�,keyΪuserName,valueΪsession
    HashMap<String, HttpSession> map = new HashMap<>();
    
    @Override
    //���session����ʱ������
    public void attributeAdded(HttpSessionBindingEvent e){        
        //����ӵ�����
        String attrName = e.getName();
        
        if(attrName.equals("userName")){
            String attrValue = (String)e.getValue();
            //��map�д��ڸ��û�
            if(map.get(attrValue)!=null){
                //����ǰ�ĵ�¼ʧЧ
                HttpSession session = map.get(attrValue);               
                session.removeAttribute("userName");                     
            }
            //���û�session���map 
            map.put(attrValue, e.getSession());
            System.out.println("�˺�:"+attrValue+",��¼");
        }      
    }
    
    @Override
    //ɾ������ǰ������
    public void attributeRemoved(HttpSessionBindingEvent e){
        //��ɾ��������
        String attrName = e.getName();       
        if(attrName.equals("userName")){
            String attrValue = (String) e.getValue();
            map.remove(attrValue);
            System.out.println("�˺ţ�"+attrValue+",ע��");
        }
    }
    
    @Override
    //�޸�����ʱ������
    public void attributeReplaced(HttpSessionBindingEvent e){
        String attrName = e.getName();
        //û��ע��������£�����һ���˺ŵ�¼
        if(attrName.equals("userName")){
            String oldValue = (String) e.getValue();
            String newValue = (String) e.getSession().getAttribute("userName");
            //ע��Ҫ�ж���ֵ��ֵ�Ƿ����
            if(!oldValue.equals(newValue)){
                //����µ�¼���˺��Ƿ��ڱ�Ļ����ϵ�¼��
                if(map.get(newValue)!=null){                
                    HttpSession session = map.get(oldValue);
                    session.removeAttribute("userName");               
                    map.remove(oldValue);
                }              
                map.put(newValue, e.getSession());
                System.out.println("ԭ�˺ţ�"+oldValue+"�������˺ţ�"+newValue+"���");
            }
            else{
                System.out.println("�˺ţ�"+oldValue+",���µ�¼");
            }
        }
    }
    
}
