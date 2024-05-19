package model;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum LottoPrize {

    FIRST(2000000000, (WinningNumberMatchCount winningCount, BonusNumberMatched bonusMatched) -> {
        return winningCount.countEquals(6) && !bonusMatched.matched();
    }),
    SECOND(30000000, (WinningNumberMatchCount winningCount, BonusNumberMatched bonusMatched) -> {
        return winningCount.countEquals(5) && bonusMatched.matched();
    }),
    THIRD(1500000, (WinningNumberMatchCount winningCount, BonusNumberMatched bonusMatched) -> {
        return winningCount.countEquals(5) && !bonusMatched.matched();
    }),
    FOURTH(50000, (WinningNumberMatchCount winningCount, BonusNumberMatched bonusMatched) -> {
        return winningCount.countEquals(4) && !bonusMatched.matched();
    }),
    FIFTH(5000, (WinningNumberMatchCount winningCount, BonusNumberMatched bonusMatched) -> {
        return winningCount.countEquals(3) && !bonusMatched.matched();
    });

    private final int prizeAmount;
    private final BiFunction<WinningNumberMatchCount, BonusNumberMatched, Boolean> prizeCriterion;

    LottoPrize(
            int prizeAmount,
            BiFunction<WinningNumberMatchCount, BonusNumberMatched, Boolean> prizeCriterion
    ) {
        this.prizeAmount = prizeAmount;
        this.prizeCriterion = prizeCriterion;
    }

    public static Optional<LottoPrize> computePrize(
            WinningNumberMatchCount winningCount,
            BonusNumberMatched bonusMatched
    ) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.meetsPrizeCriterion(winningCount, bonusMatched))
                .reduce((firstMatched, secondMatched) -> {
                    throw new IllegalStateException("조건과 일치하는 Prize가 2개 이상 존재합니다.");
                });
    }

    public boolean meetsPrizeCriterion(
            WinningNumberMatchCount winningCount,
            BonusNumberMatched bonusMatched
    ) {
        return this.prizeCriterion.apply(winningCount, bonusMatched);
    }

    public int prizeAmount() {
        return prizeAmount;
    }

}
