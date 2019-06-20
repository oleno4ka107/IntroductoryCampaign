package controller.command.util;

import model.entity.Student;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


public class ContextUtil {
    private static Map<Student, HttpSession> loggedUsers;

    public static boolean isUserInContext(HttpSession session, Student student) {
        getLoggedUsers(session);
        return loggedUsers.keySet().contains(student);
    }

    public static void logoutUser(Student student) {
        HttpSession oldSession = loggedUsers.get(student);
        oldSession.invalidate();
    }

    public static void setAttributesToContext(HttpSession session, Student student) {
        getLoggedUsers(session);
        loggedUsers.put(student, session);
    }

    @SuppressWarnings("unchecked")
    private static void getLoggedUsers(HttpSession session) {
        loggedUsers = (HashMap<Student, HttpSession>) session.getServletContext().getAttribute(
                AttributesResourceManager.getProperty("attribute.servlet.context.logged.users"));
    }
}
