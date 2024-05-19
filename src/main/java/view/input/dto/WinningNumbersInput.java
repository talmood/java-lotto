package view.input.dto;

import domain.WinningNumber;
import domain.WinningNumbers;
import exception.InvalidInputException;
import util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static constant.LottoConstants.MAX_LOTTO_NUMBER_INCLUSIVE;
import static constant.LottoConstants.MIN_LOTTO_NUMBER_INCLUSIVE;
import static exception.code.ErrorCode.COLLECTION_MUST_NOT_BE_EMPTY;
import static exception.code.ErrorCode.INVALID_RANGE_NUMBERS_INPUT;

public class WinningNumbersInput {

    private final List<Integer> winningNumbers;

    public WinningNumbersInput(List<Integer> winningNumbers) {
        this.validateWinningNumbersNotEmpty(winningNumbers);
        this.validateWinningNumbersInRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers toWinningNumbers() {
        return WinningNumbers.create(
                this.winningNumbers.stream()
                        .map(WinningNumber::create)
                        .collect(Collectors.toList())
        );
    }

    private void validateWinningNumbersInRange(List<Integer> winningNumbers) {
        if (!this.isWinningNumbersInRange(winningNumbers)) {
            throw new InvalidInputException(
                    INVALID_RANGE_NUMBERS_INPUT,
                    String.format("당첨 번호의 범위는 %d이상 %d이하 이어야 합니다.",
                            MIN_LOTTO_NUMBER_INCLUSIVE,
                            MAX_LOTTO_NUMBER_INCLUSIVE
                    )
            );
        }
    }

    private boolean isWinningNumbersInRange(List<Integer> winningNumbers) {
        return !CollectionUtils.isEmpty(winningNumbers) &&
                winningNumbers.stream()
                        .allMatch(this::isNumberInRange);
    }

    private boolean isNumberInRange(int number) {
        return number >= MIN_LOTTO_NUMBER_INCLUSIVE && number <= MAX_LOTTO_NUMBER_INCLUSIVE;
    }

    private void validateWinningNumbersNotEmpty(List<Integer> winningNumbers) {
        if (CollectionUtils.isEmpty(winningNumbers)) {
            throw new InvalidInputException(COLLECTION_MUST_NOT_BE_EMPTY, "당첨 번호는 null이거나 empty이면 안됩니다.");
        }
    }
}
