package lotto;

import java.util.List;

public class Lotto {

	private final List<LottoNumber> lottoNumbers;

	private Lotto(final List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto from(final List<LottoNumber> lottoNumbers) {
		LottoValidator.validate(lottoNumbers);
		return new Lotto(lottoNumbers);
	}

	public boolean isContains(final LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public int calculateHitCount(final Lotto lotto) {
		return (int) lottoNumbers.stream()
			.filter(lotto::isContains)
			.count();
	}

	public List<LottoNumber> lottoNumbers() {
		return this.lottoNumbers;
	}
}
