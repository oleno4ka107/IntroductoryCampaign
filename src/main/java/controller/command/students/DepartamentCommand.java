package controller.command.students;

import controller.command.Command;
import model.entity.Student;
import model.service.SpecialtyService;
import model.service.StudentService;
import model.service.impl.SpecialtyServiceImpl;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class DepartamentCommand implements Command {
    private Logger logger = Logger.getLogger(DepartamentCommand.class);
    SpecialtyService specialtyService = new SpecialtyServiceImpl();
    StudentService studentService = new StudentServiceImpl();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final HttpSession session = request.getSession();

        request.setAttribute("speciatlyList", specialtyService.findAll());
        Integer specialtyId = Integer.parseInt(request.getParameter(AttributesResourceManager.getProperty("parameter.specialty")));
        Student student = (Student) session.getAttribute(AttributesResourceManager.getProperty("parameter.user"));

        Optional.ofNullable(specialtyId).ifPresent(s -> studentService.setSpecialty(s, student));
        logger.info("execute");
        return PageResourseManager.getProperty("studentpage");
    }
}
