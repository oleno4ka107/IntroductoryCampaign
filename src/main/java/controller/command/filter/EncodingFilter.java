package controller.command.filter;


import javax.servlet.*;
import java.io.IOException;
import org.apache.log4j.Logger;

public class EncodingFilter implements Filter {
    private Logger logger = Logger.getLogger(EncodingFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("do Filter");
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
    }
}
