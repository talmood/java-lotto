package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

	@CsvSource(value = {
		"6, false, FIRST",
		"5, true, SECOND",
		"5, false, THIRD",
		"4, true, FOURTH",
		"4, false, FOURTH",
		"3, true, FIFTH",
		"3, false, FIFTH",
		"2, true, UNRANKED",
		"2, false, UNRANKED",
		"1, true, UNRANKED",
		"1, false, UNRANKED",
		"0, false, UNRANKED"
	})
	@ParameterizedTest
	void 로또_번호_적중_횟수와_보너스_번호_유무에_따른_등수를_반환한다(final int hitCount, final boolean hasBonusNumber, final LottoRank expected) {
		final LottoRank actual = LottoRank.of(hitCount, hasBonusNumber);

		assertThat(actual).isEqualTo(expected);
	}
}
