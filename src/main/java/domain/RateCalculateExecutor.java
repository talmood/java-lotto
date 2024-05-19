package domain;

import controller.AmountRequest;
import view.OutputView;
import vo.WinningTypeCollection;

public class RateCalculateExecutor {
	private final AmountRequest amountRequest;
	private final WinningTypeCollection winningTypeCollection;

	public RateCalculateExecutor(final AmountRequest amountRequest, final WinningTypeCollection winningTypeCollection) {
		this.amountRequest = amountRequest;
		this.winningTypeCollection = winningTypeCollection;
	}

	public void calculateRate() {
		// 수익률은 소수점 둘째 자리까지 출력
		final double rate = Math.round(winningTypeCollection.calculateTotalWinningPrice() / amountRequest.getLottoAmount());
		OutputView.outputRateOfReturn(rate);

	}
}
