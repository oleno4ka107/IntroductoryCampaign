package controller.validation;


public class InputValid {


    public static boolean isUkraininanValid(String text) {
        final String regex = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(text);
        return m.matches();
    }

    public static boolean isEnglishValid(String text) {
        final String regex = "^[A-Z][a-z]{1,20}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(text);
        return m.matches();
    }


    public static boolean isEmailValid(String email) {
        final String regex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;" +
                ":\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\." +
                "[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isGradeValid(Integer grade) {
        if (grade > 0 && grade <= 100) {
            return true;
        }
        return false;
    }
}