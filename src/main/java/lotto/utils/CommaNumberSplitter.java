package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class CommaNumberSplitter {
    private static final String DELIMITER = ",";

    private CommaNumberSplitter() {
    }

    public static List<Integer> split(final String str) {
        if (StringUtil.isBlank(str)) {
            throw new IllegalArgumentException("split string must not be blank");
        }

        return Arrays.stream(str.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
