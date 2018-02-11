package com.anye137.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class SessionAttributeListenerTest implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent e)  { 
        //�������ʱ������
        HttpSession session = e.getSession();
        String name = e.getName();
        System.out.println("�½�session���ԣ�"+name+"��ֵΪ��"+e.getValue());
    }
  
    public void attributeRemoved(HttpSessionBindingEvent e)  { 
        //ɾ������ǰ������
        HttpSession session = e.getSession();
        String name = e.getName();
        System.out.println("ɾ��session���ԣ�"+name+"��ֵΪ"+e.getValue());
    }
    
    public void attributeReplaced(HttpSessionBindingEvent e)  { 
        //�޸�����ʱ������
        HttpSession session = e.getSession();
        String name = e.getName();
        Object oldValue = e.getValue();
        System.out.println("�޸�session���ԣ�"+name+"��ԭֵ��"+oldValue+",��ֵ��"+session.getAttribute(name));
    }
	
}
