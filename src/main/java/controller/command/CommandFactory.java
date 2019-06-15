package controller.command;

import controller.command.admins.AdminCommand;
import controller.command.admins.SendNotificationCommandButton;
import controller.command.admins.SetGradeCommand;
import controller.command.pagesCommand.*;
import controller.command.students.DepartmentCommand;
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
        commandMap.put("studentPage/department", new DepartmentCommandPage());
        commandMap.put("studentPage/department/set", new DepartmentCommand());
        commandMap.put("registration", new RegistrationCommandPage());
        commandMap.put("registration/create", new RegistrationCommand());
        commandMap.put("admin/sendNotification", new SendNotificationCommandPage());
        commandMap.put("admin/sendNotification/send", new SendNotificationCommandButton());
        commandMap.put("admin/setGrade", new SetGradeCommandPage());
        commandMap.put("admin/setGrade/button", new SetGradeCommand());
        commandMap.put("studentPage", new StudentPageCommand());
        commandMap.put("studentPage/studentRating", new StudentRatingCommandPage());
        commandMap.put("studentPage/studentRating/show", new StudentRatingCommand());
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





