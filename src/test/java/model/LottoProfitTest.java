package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.data.Offset.offset;

class LottoProfitTest {

    @DisplayName("수익률은 당첨 금액 / 구매 금액이다.")
    @Test
    void of() {
        // given
        final LottoPurchaseAmount purchaseAmount = new LottoPurchaseAmount(1_000);
        long prizeAmount = 323748;

        // when
        final LottoProfit actual = LottoProfit.of(purchaseAmount, prizeAmount);

        // then
        Assertions.assertThat(actual.profit()).isCloseTo(323.74, offset(0.1));
    }

}