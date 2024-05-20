package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ValueSource(ints = {0, 46})
	@ParameterizedTest
	void 로또_번호는_1부터_45_사이의_숫자여야_한다(final int invalidLottoNumber) {
		assertThatThrownBy(() -> LottoNumber.from(invalidLottoNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
	}
}
