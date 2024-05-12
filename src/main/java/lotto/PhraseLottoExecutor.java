package lotto;

import controller.AmountRequest;
import view.OutputView;

public class PhraseLottoExecutor {
	private final AmountRequest amountRequest;

	public PhraseLottoExecutor(final AmountRequest amountRequest) {
		this.amountRequest = amountRequest;
	}

	public void phraseLotto() {
		int phraseLottoCount = this.amountRequest.fetchPhraseLottoCount();
		LottoNumberCollection lottoNumberCollection = LottoNumberCollection.issuanceLotto(phraseLottoCount);

		OutputView.outputPhraseLotto(phraseLottoCount, lottoNumberCollection);
	}

}
