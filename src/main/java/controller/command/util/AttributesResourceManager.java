package controller.command.util;

import java.util.ResourceBundle;

public class AttributesResourceManager {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("attributes");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
