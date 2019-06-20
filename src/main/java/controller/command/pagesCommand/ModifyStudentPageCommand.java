package controller.command.pagesCommand;

import controller.command.Command;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourseManager;
import model.entity.Student;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyStudentPageCommand implements Command {
    private Logger logger = Logger.getLogger(ModifyStudentPageCommand.class);
    StudentService studentService = new StudentServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer studentId = Integer.valueOf(request.getParameter((AttributesResourceManager.getProperty("parameter.student.id"))));
        Student student = studentService.findById(studentId);
        request.setAttribute(AttributesResourceManager.getProperty("parameter.student.id"), student.getId());
        request.setAttribute(AttributesResourceManager.getProperty("parameter.name.ua"), student.getNameUa());
        request.setAttribute(AttributesResourceManager.getProperty("parameter.surname.ua"), student.getSurnameUa());
        request.setAttribute(AttributesResourceManager.getProperty("parameter.name.en"), student.getNameEn());
        request.setAttribute(AttributesResourceManager.getProperty("parameter.surname.en"), student.getSurnameEn());
        request.setAttribute(AttributesResourceManager.getProperty("parameter.email"), student.getEmail());
        logger.info("execute");
        return PageResourseManager.getProperty("admin/modifystudent");
    }
}
