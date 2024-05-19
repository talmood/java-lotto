package lotto;

public class LottoController {

	public void run() {
		try {
			final Money money = Money.from(InputView.inputMoney());
			final LottoVendor lottoVendor = LottoVendor.from(money);

			final int manualCount = InputView.inputManualCount();
			final Lottos manualLottos = lottoVendor.purchaseManualLottos(InputView.inputManualLottoNumbers(manualCount));
			final Lottos autoLottos = lottoVendor.purchaseAutoLottos();
			OutputView.printLottoPurchaseResult(manualLottos, autoLottos);

			final Lotto lotto = Lotto.from(InputView.inputWinningLottoNumbers());
			final LottoNumber bonusLottoNumber = LottoNumber.from(InputView.inputWinningBonus());
			final WinningLotto winningLotto = WinningLotto.of(lotto, bonusLottoNumber);

			final LottoResult lottoResult = LottoResult.of(manualLottos, autoLottos, winningLotto);
			OutputView.printLottoResult(lottoResult);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e);
			run();
		}
	}
}
