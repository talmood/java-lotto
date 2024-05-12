package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberCollection {

	private final List<List<Integer>> pickLottoNumbers;

	private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
	private final static int LOTTO_NUMBER_COUNT = 6;

	static {
		for (int i = 1; i <= 45; i++) {
			LOTTO_NUMBERS.add(i);
		}
	}

	private LottoNumberCollection(final List<List<Integer>> pickLottoNumbers) {
		this.pickLottoNumbers = pickLottoNumbers;
	}

	public static LottoNumberCollection issuanceLotto(final int lottoCount) {
		List<List<Integer>> newPickedLottoNumbers = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> lottoNumbers = new ArrayList<>();
			Collections.shuffle(LOTTO_NUMBERS);

			IntStream.range(0, LOTTO_NUMBER_COUNT).forEach(index -> {
				lottoNumbers.add(LOTTO_NUMBERS.get(index));
			});
			newPickedLottoNumbers.add(lottoNumbers);
		}

		return new LottoNumberCollection(newPickedLottoNumbers);
	}

	public List<List<Integer>> getPickLottoNumbers() {
		return List.copyOf(this.pickLottoNumbers);
	}
}
