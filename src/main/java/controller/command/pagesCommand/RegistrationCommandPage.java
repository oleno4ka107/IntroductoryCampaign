package controller.command.pagesCommand;

import controller.command.Command;
import org.apache.log4j.Logger;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommandPage implements Command {
    private Logger logger = Logger.getLogger(RegistrationCommandPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("execute");
        return PageResourseManager.getProperty("registration");
    }
}
