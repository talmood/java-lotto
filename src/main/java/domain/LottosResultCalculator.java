package domain;

import exception.DomainValidationException;

import java.util.List;

import static exception.code.ErrorCode.WINNING_NUMBERS_CONTAIN_BONUS_NUMBER;

public class LottosResultCalculator {

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottosResultCalculator(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.validateBonusNumberNotContainWinningNumber(winningNumbers, bonusNumber);
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotContainWinningNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.isContainNumber(bonusNumber.fetchBonusNumber())) {
            throw new DomainValidationException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER, "보너스 번호가 당첨 번호에 포함되어있으면 안됩니다.");
        }
    }

    public LottoWinnings calculate() {
        List<LottoWinning> lottoWinnings = this.lottos.findLottoWinnings(this.winningNumbers, this.bonusNumber);

        return LottoWinnings.create(lottoWinnings);
    }
}
