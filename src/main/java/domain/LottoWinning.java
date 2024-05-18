package domain;

import java.util.Arrays;

public enum LottoWinning {
    FIRST_PLACE(2000000000, 6, 0),
    SECOND_PLACE(30000000, 5, 1),
    THIRD_PLACE(1500000, 5, 0),
    FOURTH_PLACE(50000, 4, 0),
    FIFTH_PLACE(5000, 3, 0),
    ELSE_PLACE(0, 0, 0);

    private final long winningAmount;

    private final long matchWinningNumberCount;

    private final long matchBonusNumberCount;

    LottoWinning(long winningAmount, long matchWinningNumberCount, long matchBonusNumberCount) {
        this.winningAmount = winningAmount;
        this.matchWinningNumberCount = matchWinningNumberCount;
        this.matchBonusNumberCount = matchBonusNumberCount;
    }

    public static LottoWinning findLottoWinning(long matchWinningNumberCount, long matchBonusNumberCount) {
        return Arrays.stream(LottoWinning.values())
                .filter(lottoWinning -> lottoWinning.isMatchLottoWinning(matchWinningNumberCount, matchBonusNumberCount))
                .findAny()
                .orElseGet(() -> ELSE_PLACE);
    }

    private boolean isMatchLottoWinning(long matchWinningNumberCount, long matchBonusNumberCount) {
        return this.isSameMatchWinningCount(matchWinningNumberCount) && this.isSameMatchBonusNumberCount(matchBonusNumberCount);
    }

    private boolean isSameMatchWinningCount(long matchWinningNumberCount) {
        return this.matchWinningNumberCount == matchWinningNumberCount;
    }

    private boolean isSameMatchBonusNumberCount(long matchBonusNumberCount) {
        return this.matchBonusNumberCount == matchBonusNumberCount;
    }

    public long fetchWinningAmount() {
        return this.winningAmount;
    }

    public long fetchMatchWinningNumberCount() {
        return this.matchWinningNumberCount;
    }

    public boolean isMatchBonusNumber() {
        return this.matchBonusNumberCount > 0;
    }

    public boolean isEqual(LottoWinning lottoWinning) {
        return this == lottoWinning;
    }
}
