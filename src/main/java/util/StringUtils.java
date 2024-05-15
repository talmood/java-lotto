package util;

import java.util.Objects;

public abstract class StringUtils {

    private static final String NUMERIC_PATTERN = "[+-]?\\d*(\\.\\d+)?";

    public static boolean isNumeric(String str) {
        return Objects.nonNull(str) && str.matches(NUMERIC_PATTERN);
    }
}
