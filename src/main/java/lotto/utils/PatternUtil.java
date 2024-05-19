package lotto.utils;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class PatternUtil {
    private PatternUtil() {
    }

    public static boolean isMatched(final String str, final String pattern) {
        if (Objects.isNull(str) || Objects.isNull(pattern)) {
            return false;
        }
        return Pattern.matches(pattern, str);
    }
}
