package controller.command.pagesCommand;

import controller.command.Command;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendNotificatioinCommandPage implements Command {
    private Logger logger = Logger.getLogger(SendNotificatioinCommandPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentService studentService = new StudentServiceImpl();

        logger.info("execute");
        request.setAttribute("studentsList", studentService.findAll());
        return PageResourseManager.getProperty("admin/sendnotification");
    }
}