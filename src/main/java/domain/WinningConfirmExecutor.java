package domain;

import controller.BonusNumberRequest;
import controller.WinningNumberRequest;
import strategy.WinningPriceStrategy;
import strategy.WinningPriceStrategyFactory;
import view.OutputView;
import vo.LottoNumberCollection;
import vo.LottoNumberCollectionList;
import vo.WinningTypeCollection;
import vo.param.WinningMatchParam;

import java.util.List;
import java.util.Optional;

public class WinningConfirmExecutor {
	private final LottoNumberCollectionList lottoNumberCollectionList;
	private final WinningNumberRequest winningNumberRequest;
	private final BonusNumberRequest bonusNumberRequest;

	public WinningConfirmExecutor(final LottoNumberCollectionList lottoNumberCollectionList,
								  final WinningNumberRequest winningNumberRequest,
								  final BonusNumberRequest bonusNumberRequest) {
		this.lottoNumberCollectionList = lottoNumberCollectionList;
		this.winningNumberRequest = winningNumberRequest;
		this.bonusNumberRequest = bonusNumberRequest;
	}

	public WinningTypeCollection confirmWinningType() {
		final WinningTypeCollection winningTypeCollection = new WinningTypeCollection();
		final List<LottoNumberCollection> pickedLottoNumberCollectionList = this.lottoNumberCollectionList.getLottoNumberCollectionList();

		for (LottoNumberCollection pickedLottoNumberCollection : pickedLottoNumberCollectionList) {
			int winningMatchCount = pickedLottoNumberCollection.countWinningMatch(this.winningNumberRequest.getWinningNumbers());
			boolean isMatchBonus = pickedLottoNumberCollection.isMatchBonus(this.bonusNumberRequest.getBonusNumber());

			Optional<WinningPriceStrategy> optionalStrategy = Optional.ofNullable(
				WinningPriceStrategyFactory.getInstance().create(WinningMatchParam.from(winningMatchCount, isMatchBonus))
			);
			optionalStrategy.ifPresent(winningPriceStrategy -> winningTypeCollection.addWinningType(winningPriceStrategy.fetchWinningType()));
		}

		OutputView.outputLottoWinningPrice(winningTypeCollection);
		return winningTypeCollection;
	}

}
