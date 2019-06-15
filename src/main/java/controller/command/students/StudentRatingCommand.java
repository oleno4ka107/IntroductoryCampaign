package controller.command.students;

import controller.command.Command;
import controller.command.pagesCommand.StudentRatingCommandPage;
import model.entity.Student;
import model.service.SpecialtyService;
import model.service.StudentService;
import model.service.impl.SpecialtyServiceImpl;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRatingCommand implements Command {
    private Logger logger = Logger.getLogger(StudentRatingCommand.class);
    private SpecialtyService specialtyService = new SpecialtyServiceImpl();
    private StudentService studentService = new StudentServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Student student = (Student) request.getSession().getAttribute(AttributesResourceManager.getProperty("parameter.user"));
        studentService.setMarks(student);
        request.setAttribute("speciallyList", specialtyService.findAll());
        try {
            Integer specialtyId = Integer.parseInt(request.getParameter(AttributesResourceManager.getProperty("parameter.specialty")));
            request.setAttribute("studentsReceivedList", studentService.receivedStudents(specialtyId));
        } catch (NumberFormatException e) {
            logger.debug("numberFormat", e);
            request.setAttribute("notFound", true);
            return new StudentRatingCommandPage().execute(request, response);
        }
        logger.info("execute");
        return new StudentRatingCommandPage().execute(request, response);
    }
}