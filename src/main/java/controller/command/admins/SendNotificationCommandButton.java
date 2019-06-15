package controller.command.admins;

import controller.command.Command;
import controller.command.pagesCommand.SendNotificationCommandPage;
import controller.command.util.EmailSender;
import org.apache.log4j.Logger;
import controller.command.util.AttributesResourceManager;
import controller.command.util.PageResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendNotificationCommandButton implements Command {
    private Logger logger = Logger.getLogger(SendNotificationCommandPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("execute");
        String email = request.getParameter(AttributesResourceManager.getProperty("parameter.email"));
        EmailSender.send(email);

        return PageResourceManager.getProperty("redirect.admin.notification");
    }
}
