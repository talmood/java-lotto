package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

	private static final int LOTTO_NUMBER_COUNT = 6;
	static void validate(final List<LottoNumber> lottoNumbers) {
		validateLottoNumberCount(lottoNumbers);
		validateLottoNumberDuplication(lottoNumbers);
	}

	static void validateLottoNumberCount(final List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 번호 개수는 6개여야 합니다.");
		}
	}

	static void validateLottoNumberDuplication(final List<LottoNumber> lottoNumbers) {
		final Set<LottoNumber> duplicatedLottoNumbers = new HashSet<LottoNumber>(lottoNumbers);

		if (duplicatedLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또는 중복된 번호가 존재할 수 없습니다.");
		}
	}
}
