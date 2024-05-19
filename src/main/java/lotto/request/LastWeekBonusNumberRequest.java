package lotto.request;

import java.util.Objects;

public class LastWeekBonusNumberRequest {

    private static final String INPUT_PATTERN = "^\\d+$";
    private static final String ERROR_INPUT_PATTERN = "[ERROR] 보너스 볼은 숫자로 입력해야 합니다.";

    private final int bonusNumber;

    private LastWeekBonusNumberRequest(final int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static LastWeekBonusNumberRequest from(final String bonusNumber) {
        validateInputPattern(bonusNumber);
        return new LastWeekBonusNumberRequest(Integer.parseInt(bonusNumber));
    }

    private static void validateInputPattern(final String bonusNumber) {
        if (Objects.isNull(bonusNumber) || !bonusNumber.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException(ERROR_INPUT_PATTERN);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
