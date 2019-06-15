package controller.command.pagesCommand;

import controller.command.Command;
import org.apache.log4j.Logger;
import controller.command.util.PageResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendNotificationCommandPage implements Command {
    private Logger logger = Logger.getLogger(SendNotificationCommandPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        logger.info("execute");
        return PageResourceManager.getProperty("admin/sendNotification");
    }
}