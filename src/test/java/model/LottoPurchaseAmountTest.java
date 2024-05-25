package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {

    @DisplayName("로또 구매 금액은 1,000원 이상부터 1,000원 단위로 구매 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10_000, 100_000})
    void new_amount(int amount) {
        final LottoPurchaseAmount actual = new LottoPurchaseAmount(amount);
        assertThat(actual.amount()).isEqualTo(amount);
    }

    @DisplayName("로또 구매 금액이 천 원 이하일 경우 예외 발생")
    @Test
    void new_negative_amount() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 최소 1000원 이상이어야합니다.");
    }

    @DisplayName("로또 구매 금액이 천 원 단위가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1010, 1100})
    void amount_unit(int amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 1000원 단위여야합니다.");
    }

    @DisplayName("로또 게임 횟수는 1000원 당 한 게임이다.")
    @ParameterizedTest
    @CsvSource({
            "1000,1",
            "13_000,13"
    })
    void calculateGameSize(int amount, int expectedGameSize) {
        final LottoPurchaseAmount sut = new LottoPurchaseAmount(amount);
        assertThat(sut.calculateGameSize()).isEqualTo(expectedGameSize);
    }

}