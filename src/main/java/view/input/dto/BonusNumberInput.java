package view.input.dto;

import domain.BonusNumber;
import exception.InvalidInputException;

import static exception.code.ErrorCode.INVALID_BONUS_NUMBER_RANGE;

public class BonusNumberInput {

    private static final int MIN_LOTTO_NUMBER_INCLUSIVE = 1;

    private static final int MAX_LOTTO_NUMBER_INCLUSIVE = 45;

    private final int bonusNumber;

    public BonusNumberInput(int bonusNumber) {
        this.validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber toBonusNumber() {
        return BonusNumber.create(this.bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (!isNumberInRange(bonusNumber)) {
            throw new InvalidInputException(
                    INVALID_BONUS_NUMBER_RANGE,
                    String.format("보너스 번호의 범위는 %d이상 %d이하 여야 합니다.",
                            MIN_LOTTO_NUMBER_INCLUSIVE,
                            MAX_LOTTO_NUMBER_INCLUSIVE
                    )
            );
        }
    }

    private boolean isNumberInRange(int number) {
        return number >= MIN_LOTTO_NUMBER_INCLUSIVE && number <= MAX_LOTTO_NUMBER_INCLUSIVE;
    }
}
