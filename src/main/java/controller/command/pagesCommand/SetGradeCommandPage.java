package controller.command.pagesCommand;

import controller.command.Command;
import model.service.SubjectService;
import model.service.StudentService;
import model.service.impl.SubjectServiceImpl;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetGradeCommandPage implements Command {
    private Logger logger = Logger.getLogger(RegistrationCommandPage.class);

    SubjectService subjectService = new SubjectServiceImpl();
    StudentService studentService = new StudentServiceImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
logger.info("execute");
        request.setAttribute("databaseListStudent", studentService.findAll());
        request.setAttribute("databaseListSubject", subjectService.findAll());
        return PageResourseManager.getProperty("admin/setgrade");
    }
}
