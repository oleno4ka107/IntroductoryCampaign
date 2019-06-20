package controller.command.filter;
import org.apache.log4j.Logger;
import controller.command.util.PageResourseManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter  {
    private Logger logger = Logger.getLogger(AuthenticationFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter");
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession session = request.getSession();
        String loginURI = request.getContextPath() + "/university/login";
        String registrationURI = request.getContextPath() + "/university/registration";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean signUpRequest = request.getRequestURI().equals(registrationURI);
        if (loggedIn || loginRequest || signUpRequest) {
            filterChain.doFilter(request, response);
        } else if (request.getRequestURI().equals("/university/registration")) {
            logger.info("Registration Forward");
            request.getRequestDispatcher(PageResourseManager.getProperty("registration")).forward(request,response);

        }
        else if (request.getRequestURI().equals("/university/login")) {
            logger.info("Login Forward");

            request.getRequestDispatcher(PageResourseManager.getProperty("login")).forward(request, response);
        }
        else {
response.sendRedirect("/university/login");
        }

    }
    @Override
    public void destroy() {

    }
}
