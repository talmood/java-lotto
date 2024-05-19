package utils;

public class NumericUtils {

    private NumericUtils() {
    }

    public static boolean isNumericString(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
