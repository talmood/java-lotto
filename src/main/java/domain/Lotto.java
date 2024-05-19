package domain;

import exception.DomainValidationException;

import java.util.HashSet;
import java.util.List;

import static constant.LottoConstants.*;
import static exception.code.ErrorCode.*;

public class Lotto {

    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.validateLottoNumbersSize(lottoNumbers);
        this.validateLottoNumbersUnique(lottoNumbers);
        this.validateLottoNumbersInRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void validateLottoNumbersInRange(List<Integer> lottoNumbers) {
        if (!isAllLottoNumberRange(lottoNumbers)) {
            throw new DomainValidationException(
                    INVALID_LOTTO_NUMBER_RANGE,
                    String.format("로또 번호의 범위는 %d부터 %d까지 입니다.",
                            MIN_LOTTO_NUMBER_INCLUSIVE,
                            MAX_LOTTO_NUMBER_INCLUSIVE
                    )
            );
        }
    }

    private void validateLottoNumbersSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new DomainValidationException(
                    INVALID_LOTTO_NUMBERS_SIZE,
                    String.format("로또 번호의 갯수는 %d개여야 합니다.", LOTTO_NUMBERS_SIZE)
            );
        }
    }

    private void validateLottoNumbersUnique(List<Integer> lottoNumbers) {
        if (!isUniqueLottoNumbers(lottoNumbers)) {
            throw new DomainValidationException(NOT_UNIQUE_LOTTO_NUMBERS, "로또 번호는 모두 달라야 합니다.");
        }
    }

    private boolean isAllLottoNumberRange(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .allMatch(this::isLottoNumberRange);
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_LOTTO_NUMBER_INCLUSIVE && number <= MAX_LOTTO_NUMBER_INCLUSIVE;
    }

    private boolean isUniqueLottoNumbers(List<Integer> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() == lottoNumbers.size();
    }

    public List<Integer> fetchLottoNumberList() {
        return List.copyOf(this.lottoNumbers);
    }

    private long countMatchWinningNumbers(WinningNumbers winningNumbers) {
        return winningNumbers.countMatchNumbers(this.lottoNumbers);
    }

    private long countMatchBonusNumber(BonusNumber bonusNumber) {
        return this.lottoNumbers.stream()
                .filter(bonusNumber::isSameNumber)
                .count();
    }

    public LottoWinning findLottoWinning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        long matchedWinningNumberCount = this.countMatchWinningNumbers(winningNumbers);
        long matchedBonusNumberCount = this.countMatchBonusNumber(bonusNumber);

        return LottoWinning.findLottoWinning(matchedWinningNumberCount, matchedBonusNumberCount);
    }
}
