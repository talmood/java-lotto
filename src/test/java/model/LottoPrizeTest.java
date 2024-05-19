package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("당첨 번호가 6개 일치하고 보너스 번호 불일치 시 1등")
    @Test
    void first() {
        assertLottoPrize(6, BonusNumberMatched.ofNotMatched(), LottoPrize.FIRST);
    }

    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호는 일치 시 2등")
    @Test
    void second() {
        assertLottoPrize(5, BonusNumberMatched.ofMatched(), LottoPrize.SECOND);
    }

    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호는 불일치 시 3등")
    @Test
    void third() {
        assertLottoPrize(5, BonusNumberMatched.ofNotMatched(), LottoPrize.THIRD);
    }

    @DisplayName("당첨 번호가 4개 일치하고 보너스 번호는 불일치 시 4등")
    @Test
    void fourth() {
        assertLottoPrize(4, BonusNumberMatched.ofNotMatched(), LottoPrize.FOURTH);
    }

    @DisplayName("당첨 번호가 3개 일치하고 보너스 번호는 불일치 시 5등")
    @Test
    void fifth() {
        assertLottoPrize(3, BonusNumberMatched.ofNotMatched(), LottoPrize.FIFTH);
    }

    private void assertLottoPrize(int winningNumberMatchCount, BonusNumberMatched bonusMatched, LottoPrize expectedPrize) {
        final LottoPrize actual = LottoPrize.computePrize(new WinningNumberMatchCount(winningNumberMatchCount), bonusMatched);
        assertThat(actual).isEqualTo(expectedPrize);
    }

}