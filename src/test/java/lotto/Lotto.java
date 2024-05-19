package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private static final int LOTTO_NUMBER_COUNT = 6;

	private final List<LottoNumber> lottoNumbers;

	private Lotto(final List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto from(final List<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);
		return new Lotto(lottoNumbers);
	}

	private static void validate(final List<LottoNumber> lottoNumbers) {
		validateLottoNumberCount(lottoNumbers);
		validateLottoNumberDuplication(lottoNumbers);
	}

	private static void validateLottoNumberCount(final List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 번호 개수는 6개여야 합니다.");
		}
	}
	
	private static void validateLottoNumberDuplication(final List<LottoNumber> lottoNumbers) {
		final Set<LottoNumber> duplicatedLottoNumbers = new HashSet<>(lottoNumbers);

		if (duplicatedLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또는 중복된 번호가 존재할 수 없습니다.");
		}
	}
}
