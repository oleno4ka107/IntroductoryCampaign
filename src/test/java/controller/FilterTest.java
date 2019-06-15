package controller;

import controller.command.filter.AuthenticationFilter;
import controller.command.filter.RoleFilter;
import model.entity.Student;
import model.entity.types.Role;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class FilterTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    FilterChain filterChain;
    @Mock
    HttpSession session;


    @Before
    public void setUp() {
        Student student = new Student();
        student.setEmail("test");
        student.setRole(Role.ADMIN.getRole());

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(student);
        when(request.getRequestURI()).thenReturn("/university/admin");

    }

    @Test
    public void testAuthenficationFilter() throws IOException, ServletException {

        // mock the getRequestURI() response
        when(request.getRequestURI()).thenReturn("/otherurl.jsp");

        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        authenticationFilter.doFilter(request, response,
                filterChain);

        // verify if a sendRedirect() was performed with the expected value
        verify(response).sendRedirect("/university/login");
    }

    @Test
    public void testRoleFilter() throws IOException, ServletException {
        RoleFilter roleFilter = new RoleFilter();
        roleFilter.doFilter(request, response, filterChain);

    }


}