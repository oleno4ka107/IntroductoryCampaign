package controller.command.listener;

import model.entity.Student;
import controller.command.util.AttributesResourceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().addListener(new SessionListener());
        servletContextEvent.getServletContext().setAttribute(
                AttributesResourceManager.getProperty("attribute.servlet.context.logged.users"),
                new HashMap<Student, HttpSession>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
