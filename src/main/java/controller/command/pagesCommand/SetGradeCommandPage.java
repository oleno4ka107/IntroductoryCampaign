package controller.command.pagesCommand;

import controller.command.Command;
import model.service.SubjectService;
import model.service.impl.SubjectServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.PageResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetGradeCommandPage implements Command {
    private Logger logger = Logger.getLogger(RegistrationCommandPage.class);

    SubjectService subjectService = new SubjectServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("execute");
        request.setAttribute("databaseList", subjectService.findAll());
        return PageResourceManager.getProperty("admin/setGrade");
    }
}
