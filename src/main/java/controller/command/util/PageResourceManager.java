package controller.command.util;

import java.util.ResourceBundle;

public class PageResourceManager {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("pages");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
