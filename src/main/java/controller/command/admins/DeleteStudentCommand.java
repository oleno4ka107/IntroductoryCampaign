package controller.command.admins;

import controller.command.Command;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourseManager;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteStudentCommand implements Command {
    private Logger logger = Logger.getLogger(DeleteStudentCommand.class);
    StudentService studentService = new StudentServiceImpl();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer studentId = Integer.valueOf(request.getParameter((AttributesResourceManager.getProperty("parameter.student.id"))));
        studentService.delete(studentId);
        logger.info("execute");
        return PageResourseManager.getProperty("redirect.admin.studentlist");
    }
}
