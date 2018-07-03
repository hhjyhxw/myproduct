package zhumeng.com.uimei.listeners;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: SessionListener.java
 * @Package zhumeng.com.uimei.listeners
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年6月29日
 * @version V1.0
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{

	public static final Logger logger= LoggerFactory.getLogger(SessionListener.class);
	 
    @Override
    public void  attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info("--attributeAdded--");
        HttpSession session=httpSessionBindingEvent.getSession();
        logger.info("key----:"+httpSessionBindingEvent.getName());
        logger.info("value---:"+httpSessionBindingEvent.getValue());
 
    }
 
    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
    	logger.info("--attributeRemoved--");
    }
 
    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    	logger.info("--attributeReplaced--");
    }
 
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("---sessionCreated----");
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        // 在application范围由一个HashSet集保存所有的session
        HashSet sessions = (HashSet) application.getAttribute("sessions");
        if (sessions == null) {
            sessions = new HashSet();
            application.setAttribute("sessions", sessions);
        }
        // 新创建的session均添加到HashSet集中
       sessions.add(session);
        // 可以在别处从application范围中取出sessions集合
        // 然后使用sessions.size()获取当前活动的session数，即为“在线人数”
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) throws ClassCastException {
        logger.info("---sessionDestroyed----");
        HttpSession session = event.getSession();
        logger.info("deletedSessionId: "+session.getId());
        System.out.println(session.getCreationTime());
        System.out.println(session.getLastAccessedTime());
        ServletContext application = session.getServletContext();
        HashSet sessions = (HashSet) application.getAttribute("sessions");
        // 销毁的session均从HashSet集中移除
        sessions.remove(session);
    }

}
