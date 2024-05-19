package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

	@Test
	void 돈은_음수가_될_수_없다() {
		assertThatThrownBy(() ->Money.from(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("돈은 음수가 될 수 없습니다.");
	}

	@Test
	void 돈은_0원이_될_수_없다() {
		assertThatThrownBy(() ->Money.from(0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("최소 1원 이상이어야 합니다.");
	}

	@CsvSource(value = {
		"1, 2, false",
		"2, 1, true"
	})
	@ParameterizedTest
	void 입력받은_가격보다_돈이_충분한지_판단한다(final int money, final int price, final boolean expected) {
		final Money sut = Money.from(money);

		final boolean actual = sut.hasEnoughMoneyFor(price);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 입력받은_가격에_대해_구매_가능한_개수를_반환한다() {
		final Money sut = Money.from(5000);

		final int actual = sut.calculatePurchasableCount(1000);

		assertThat(actual).isEqualTo(5);
	}
}
