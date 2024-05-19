package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLottoPurchaseAmountTest {

    @DisplayName("입력한 로또 구매 금액이 숫자가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1231aa", ","})
    @NullAndEmptySource
    void fromAmountString(String amountString) {
        assertThatThrownBy(() -> InputLottoPurchaseAmount.fromAmountString(amountString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 숫자여야합니다.");
    }

}