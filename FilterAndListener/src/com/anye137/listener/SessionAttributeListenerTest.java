package com.anye137.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class SessionAttributeListenerTest implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent e)  { 
        //添加属性时被调用
        HttpSession session = e.getSession();
        String name = e.getName();
        System.out.println("新建session属性："+name+"，值为："+e.getValue());
    }
  
    public void attributeRemoved(HttpSessionBindingEvent e)  { 
        //删除属性前被调用
        HttpSession session = e.getSession();
        String name = e.getName();
        System.out.println("删除session属性："+name+"，值为"+e.getValue());
    }
    
    public void attributeReplaced(HttpSessionBindingEvent e)  { 
        //修改属性时被调用
        HttpSession session = e.getSession();
        String name = e.getName();
        Object oldValue = e.getValue();
        System.out.println("修改session属性："+name+"，原值："+oldValue+",新值："+session.getAttribute(name));
    }
	
}
