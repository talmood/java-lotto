package lotto;

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

public class LottoTest {

	@MethodSource("provideLottoNumbers")
	@ParameterizedTest
	void 로또_번호_개수는_무조건_6개여야_한다(final List<LottoNumber> invalidLottoNumbers) {
		assertThatThrownBy(() -> Lotto.from(invalidLottoNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 번호 개수는 6개여야 합니다.");
	}

	@Test
	void 로또는_중복된_번호가_존재할_수_없다() {
		assertThatThrownBy(() -> Lotto.from(LottoTest.createLottoNumbers(1, 1, 3, 4, 5, 6)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또는 중복된 번호가 존재할 수 없습니다.");
	}

	private static Stream<Arguments> provideLottoNumbers() {
		return Stream.of(
			arguments(createLottoNumbers(1, 2, 3, 4, 5)),
			arguments(createLottoNumbers(1, 2, 3, 4, 5, 6, 7))
		);
	}

	private static List<LottoNumber> createLottoNumbers(final int... lottoNumbers) {
		return Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::from)
			.collect(Collectors.toList());
	}
}
