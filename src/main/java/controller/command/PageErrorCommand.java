package controller.command;

import org.apache.log4j.Logger;
import controller.command.util.PageResourseManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageErrorCommand implements Command {
    private static Logger logger = Logger.getLogger(PageErrorCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("execute");

        return PageResourseManager.getProperty("page_not_found");
    }
}
