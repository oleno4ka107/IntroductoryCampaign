package controller.command.pagesCommand;

import controller.command.Command;
import model.service.SpecialtyService;
import model.service.impl.SpecialtyServiceImpl;
import org.apache.log4j.Logger;
import controller.command.util.PageResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRatingCommandPage implements Command {
    private Logger logger = Logger.getLogger(RegistrationCommandPage.class);

    SpecialtyService specialtyService = new SpecialtyServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("execute");
        request.setAttribute("speciallyList", specialtyService.findAll());


        return PageResourceManager.getProperty("studentPage/studentRating");
    }
}