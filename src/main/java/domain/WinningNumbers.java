package domain;

import exception.DomainValidationException;
import util.CollectionUtils;

import java.util.HashSet;
import java.util.List;

import static exception.code.ErrorCode.COLLECTION_MUST_NOT_BE_EMPTY;
import static exception.code.ErrorCode.NOT_UNIQUE_WINNING_NUMBERS;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;

    private WinningNumbers(List<WinningNumber> winningNumbers) {
        this.validateNotEmpty(winningNumbers);
        this.validateAllNumbersUnique(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers create(List<WinningNumber> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    private void validateNotEmpty(List<WinningNumber> winningNumbers) {
        if (CollectionUtils.isEmpty(winningNumbers)) {
            throw new DomainValidationException(COLLECTION_MUST_NOT_BE_EMPTY, "당첨 번호는 null이거나 empty이면 안됩니다.");
        }
    }

    private void validateAllNumbersUnique(List<WinningNumber> winningNumbers) {
        if (!isUniqueWinningNumbers(winningNumbers)) {
            throw new DomainValidationException(NOT_UNIQUE_WINNING_NUMBERS, "당첨 번호는 모두 다른 값이여야 합니다.");
        }
    }

    private boolean isUniqueWinningNumbers(List<WinningNumber> winningNumbers) {
        return new HashSet<>(winningNumbers).size() == winningNumbers.size();
    }

    public long countMatchNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isContainNumber)
                .count();
    }

    public boolean isContainNumber(int number) {
        long count = this.winningNumbers.stream()
                .filter(winningNumber -> winningNumber.isSameNumber(number))
                .count();

        return count > 0;
    }
}
