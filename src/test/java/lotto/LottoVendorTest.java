package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoVendorTest {

	@Test
	void 로또를_사려면_로또_한_장_가격의_돈은_줘야_한다() {
		final Money money = Money.from(999);

		assertThatThrownBy(() -> LottoVendor.from(money))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 한 장 가격은 1,000원입니다. 로또를 구매하시려면 1,000원 이상 입력해 주세요.");
	}

	@CsvSource(value = {
		"1000, 1",
		"1500, 1",
		"2000, 2"
	})
	@ParameterizedTest
	void 구매_가능한_개수만큼_로또를_반환한다(final int value, final int expected) {
		final Money money = Money.from(value);
		final LottoVendor sut = LottoVendor.from(money);

		final Lottos actual = sut.purchaseAutoLottos();

		assertThat(actual.countPurchasedLottos()).isEqualTo(expected);
	}
}
