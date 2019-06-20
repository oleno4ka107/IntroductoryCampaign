package controller.command;

import controller.command.admins.AdminCommand;
import controller.command.admins.SendNotificationCommandButton;
import controller.command.admins.SetGradeCommand;
import controller.command.admins.StudentListCommand;
import controller.command.pagesCommand.*;
import controller.command.students.DepartamentCommand;
import controller.command.students.StudentPageCommand;
import controller.command.students.StudentRatingCommand;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Logger logger = Logger.getLogger(CommandFactory.class);

    static private Map<String, Command> commandMap = new HashMap<>();


    static {
        commandMap.put("admin", new AdminCommand());
        commandMap.put("login", new LoginCommand());
        commandMap.put("studentpage/departament", new DepartamentCommandPage());
        commandMap.put("studentpage/departament/set", new DepartamentCommand());
        commandMap.put("registration", new RegistrationCommandPage());
        commandMap.put("registration/create", new RegistrationCommand());
        commandMap.put("admin/sendnotification", new SendNotificatioinCommandPage());
        commandMap.put("admin/sendnotification/send", new SendNotificationCommandButton());
        commandMap.put("admin/setgrade", new SetGradeCommandPage());
        commandMap.put("admin/setgrade/button", new SetGradeCommand());
        commandMap.put("admin/studentlist", new StudentListCommand());
        commandMap.put("studentpage", new StudentPageCommand());
        commandMap.put("studentpage/studentrating", new StudentRatingCommandPage());
        commandMap.put("studentpage/studentrating/show", new StudentRatingCommand());
        commandMap.put("main", new MainCommand());
        commandMap.put("logout", new LogoutCommand());


    }

    public static Command getCommand(String url) {
        logger.info("Command get");
        Command command = commandMap.get(url);
        if (command == null) {
            return new PageErrorCommand();
        }
        return command;
    }

}





