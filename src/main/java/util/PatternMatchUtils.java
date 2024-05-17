package util;

import java.util.Objects;

public class PatternMatchUtils {

    public static boolean matches(String regex, String str) {
        return Objects.nonNull(str) && str.matches(regex);
    }
}
