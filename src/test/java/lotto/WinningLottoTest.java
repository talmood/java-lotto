package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

	@Test
	void 보너스_번호는_당첨_로또_번호와_겹칠_수_없다() {
		final Lotto lotto = Lotto.from(createLottoNumbers(1, 2, 3, 4, 5, 6));
		final LottoNumber lottoNumber = LottoNumber.from(1);

		assertThatThrownBy(() -> WinningLotto.of(lotto, lottoNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("당첨 번호와 보너스 번호는 겹칠 수 없습니다.");
	}

	@MethodSource("provideLotto")
	@ParameterizedTest
	void 당첨_로또와_내가_구매한_로또를_가지고_등수를_확인한다(final int[] lottoNumbers, final LottoRank expected) {
		final WinningLotto sut = WinningLotto.of(Lotto.from(createLottoNumbers(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));

		final LottoRank actual = sut.calculateRank(Lotto.from(createLottoNumbers(lottoNumbers)));

		assertThat(actual).isEqualTo(expected);
	}

	public static Stream<Arguments> provideLotto() {
		return Stream.of(
			arguments(new int[]{1, 2, 3, 4, 5, 6}, LottoRank.FIRST),
			arguments(new int[] {2, 3, 4, 5, 6, 7}, LottoRank.SECOND),
			arguments(new int[] {2, 3, 4, 5, 6, 8}, LottoRank.THIRD),
			arguments(new int[] {3, 4, 5, 6, 7, 8}, LottoRank.FOURTH),
			arguments(new int[] {3, 4, 5, 6, 8, 9}, LottoRank.FOURTH),
			arguments(new int[] {4, 5, 6, 7, 8, 9}, LottoRank.FIFTH),
			arguments(new int[] {4, 5, 6, 8, 9, 10}, LottoRank.FIFTH),
			arguments(new int[] {5, 6, 7, 8, 9, 10}, LottoRank.UNRANKED),
			arguments(new int[] {5, 6, 8, 9, 10, 11}, LottoRank.UNRANKED),
			arguments(new int[] {6, 7, 8, 9, 10, 11}, LottoRank.UNRANKED),
			arguments(new int[] {6, 8, 9, 10, 11, 12}, LottoRank.UNRANKED),
			arguments(new int[] {8, 9, 10, 11, 12, 13}, LottoRank.UNRANKED)
		);
	}

	private List<LottoNumber> createLottoNumbers(final int... lottoNumbers) {
		return Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::from)
			.collect(Collectors.toList());
	}
}
