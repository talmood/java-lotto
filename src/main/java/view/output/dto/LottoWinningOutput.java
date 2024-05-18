package view.output.dto;

import domain.LottoWinning;

public class LottoWinningOutput {

    private final long matchWinningNumberCount;

    private final long winningAmount;

    private final boolean isMatchBonusNumber;

    private final long matchCount;

    public LottoWinningOutput(long matchWinningNumberCount, long winningAmount, boolean isMatchBonusNumber, long matchCount) {
        this.matchWinningNumberCount = matchWinningNumberCount;
        this.winningAmount = winningAmount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.matchCount = matchCount;
    }

    public static LottoWinningOutput of(LottoWinning lottoWinning, long matchCount) {
        return new LottoWinningOutput(
                lottoWinning.fetchMatchWinningNumberCount(),
                lottoWinning.fetchWinningAmount(),
                lottoWinning.isMatchBonusNumber(),
                matchCount
        );
    }

    public long fetchMatchWinningNumberCount() {
        return matchWinningNumberCount;
    }

    public long fetchWinningAmount() {
        return winningAmount;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }

    public long fetchMatchCount() {
        return matchCount;
    }
}
