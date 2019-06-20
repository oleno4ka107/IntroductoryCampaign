package controller.command.util;

public class CommandUtil {


    public static String getUserPageByRole(int accessLevel) {
        String page = "";
        switch (accessLevel) {
            case 2:
                page = "redirect:/studentpage";
                break;
            case 3:
                page = "redirect:/admin";
                break;
            default:
        }
        return page;

    }
}
