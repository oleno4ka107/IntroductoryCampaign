package controller.command.filter;

import controller.command.util.CommandUtil;
import model.entity.Student;
import model.entity.types.Role;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class RoleFilter implements Filter {
    private Logger logger = Logger.getLogger(RoleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Do Filter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        Student student = (Student) session.getAttribute(AttributesResourceManager.getProperty("parameter.user"));
        String path = req.getRequestURI();
        if (path.contains("admin")) {
            if (Objects.nonNull(student.getEmail()) && student.getRole().equals(Role.ADMIN.getRole())) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                CommandUtil.getUserPageByRole(student.getRole());
                return;
            }
        } else if (path.contains("studentPage")) {
            if (Objects.nonNull(student.getEmail()) && student.getRole().equals(Role.ABITURIENT.getRole())) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                CommandUtil.getUserPageByRole(student.getRole());
                return;
            }

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


    @Override
    public void destroy() {

    }
}
