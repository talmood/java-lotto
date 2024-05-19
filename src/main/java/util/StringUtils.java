package util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class StringUtils {

    private static final String NUMERIC_PATTERN = "[+-]?\\d*(\\.\\d+)?";

    public static boolean isNumeric(String str) {
        return Objects.nonNull(str) && str.matches(NUMERIC_PATTERN);
    }

    public static List<Integer> splitStrToNumbers(String delimiter, String input) {
        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
