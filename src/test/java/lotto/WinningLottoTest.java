package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	@Test
	void 보너스_번호는_당첨_로또_번호와_겹칠_수_없다() {
		final Lotto lotto = Lotto.from(createLottoNumbers(1, 2, 3, 4, 5, 6));
		final LottoNumber lottoNumber = LottoNumber.from(1);

		assertThatThrownBy(() -> WinningLotto.of(lotto, lottoNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("당첨 번호와 보너스 번호는 겹칠 수 없습니다.");
	}

	private List<LottoNumber> createLottoNumbers(final int... lottoNumbers) {
		return Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::from)
			.collect(Collectors.toList());
	}
}
