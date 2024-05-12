package domain;

import controller.AmountRequest;
import view.OutputView;
import vo.LottoNumberCollection;
import vo.LottoNumberCollectionList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PhraseLottoExecutor {
	private final AmountRequest amountRequest;

	private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
	private final static int LOTTO_NUMBER_COUNT = 6;

	static {
		for (int i = 1; i <= 45; i++) {
			LOTTO_NUMBERS.add(i);
		}
	}

	public PhraseLottoExecutor(final AmountRequest amountRequest) {
		this.amountRequest = amountRequest;
	}

	public void phraseLotto() {
		OutputView.outputPhraseLotto(this.amountRequest.fetchPhraseLottoCount());
	}

	public LottoNumberCollectionList pickLottoNumber() {
		List<LottoNumberCollection> lottoNumberCollectionList = new ArrayList<>();

		for (int i = 0; i < this.amountRequest.fetchPhraseLottoCount(); i++) {
			List<Integer> pickLottoNumbers = new ArrayList<>();
			Collections.shuffle(LOTTO_NUMBERS);
			IntStream.range(0, LOTTO_NUMBER_COUNT).forEach(index -> {
				pickLottoNumbers.add(LOTTO_NUMBERS.get(index));
			});

			final LottoNumberCollection lottoNumberCollection = LottoNumberCollection.of(pickLottoNumbers);
			OutputView.outputPickedLottoNumber(lottoNumberCollection);
			lottoNumberCollectionList.add(lottoNumberCollection);
		}

		return LottoNumberCollectionList.of(lottoNumberCollectionList);
	}

}
