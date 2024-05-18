package domain;

import controller.AmountRequest;
import controller.ManualNumberRequest;
import view.OutputView;
import vo.LottoNumberCollection;
import vo.LottoNumberCollectionList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PhraseLottoExecutor {
	private final AmountRequest amountRequest;
	private final ManualNumberRequest manualNumberRequest;

	private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
	private final static int LOTTO_NUMBER_COUNT = 6;

	static {
		for (int i = 1; i <= 45; i++) {
			LOTTO_NUMBERS.add(i);
		}
	}

	public PhraseLottoExecutor(final AmountRequest amountRequest, final ManualNumberRequest manualNumberRequest) {
		this.amountRequest = amountRequest;
		this.manualNumberRequest = manualNumberRequest;
	}

	public void phraseLotto() {
		OutputView.outputPhraseLotto(this.manualNumberRequest.getManualCount(), calculateRandomPickCount());
	}

	public LottoNumberCollectionList pickLottoNumber() {
		List<LottoNumberCollection> lottoNumberCollectionRequest = fetchRandomLottoNumberCollectionList();

		LottoNumberCollectionList lottoNumberCollectionList = this.manualNumberRequest.getLottoNumberCollectionList();
		lottoNumberCollectionList.addAllLottoNumberCollection(LottoNumberCollectionList.from(lottoNumberCollectionRequest));
		OutputView.outputPickedLottoNumber(lottoNumberCollectionList);
		return lottoNumberCollectionList;
	}

	private List<LottoNumberCollection> fetchRandomLottoNumberCollectionList() {
		List<LottoNumberCollection> lottoNumberCollectionRequest = new ArrayList<>();

		for (int i = 0; i < calculateRandomPickCount(); i++) {
			List<Integer> pickLottoNumbers = new ArrayList<>();
			Collections.shuffle(LOTTO_NUMBERS);
			IntStream.range(0, LOTTO_NUMBER_COUNT).forEach(index -> {
				pickLottoNumbers.add(LOTTO_NUMBERS.get(index));
			});

			lottoNumberCollectionRequest.add(LottoNumberCollection.from(pickLottoNumbers));
		}
		return lottoNumberCollectionRequest;
	}

	private int calculateRandomPickCount() {
		return this.amountRequest.fetchPhraseLottoCount() - this.manualNumberRequest.getManualCount();
	}

}
