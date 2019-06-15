package controller.command.listener;

import model.entity.Student;
import controller.command.util.AttributesResourceManager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        Student user = (Student) session.getAttribute(AttributesResourceManager.getProperty("parameter.user"));
        ServletContext servletContext = session.getServletContext();
        Map<Student, HttpSession> loggedUsers =
                (HashMap<Student, HttpSession>) servletContext.getAttribute(
                        AttributesResourceManager.getProperty("attribute.servlet.context.logged.users"));
        loggedUsers.remove(user);
    }
}