package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberAutoGenerator implements LottoNumberGenerator {

	private static final List<Integer> lottoNumbers;

	static {
		lottoNumbers = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
			.boxed()
			.collect(Collectors.toList());
	}

	@Override
	public List<LottoNumber> generate() {
		Collections.shuffle(lottoNumbers);
		return lottoNumbers.stream()
			.limit(6)
			.sorted()
			.map(LottoNumber::from)
			.collect(Collectors.toList());
	}
}
