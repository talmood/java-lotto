package util;

import java.util.Objects;

public abstract class PatternMatchUtils {

    public static boolean matches(String regex, String str) {
        return Objects.nonNull(str) && str.matches(regex);
    }
}
