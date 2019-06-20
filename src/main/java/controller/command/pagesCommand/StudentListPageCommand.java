package controller.command.pagesCommand;

import controller.command.Command;
import controller.command.util.PageResourseManager;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListPageCommand implements Command {
    private Logger logger = Logger.getLogger(StudentListPageCommand.class);
    StudentService studentService = new StudentServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("studentsList", studentService.findAll());
        logger.info("execute");
        return PageResourseManager.getProperty("admin/studentlist");
    }
}
