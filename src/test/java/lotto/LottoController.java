package lotto;

public class LottoController {

	public void run() {
		try {
			final Money money = Money.from(InputView.inputMoney());
			final LottoVendor lottoVendor = LottoVendor.from(money);
			final Lottos lottos = lottoVendor.purchaseAutoLottos();
			OutputView.printLottoPurchaseResult(lottos);

			final Lotto lotto = Lotto.from(InputView.inputWinningLottoNumbers());
			final LottoNumber bonusLottoNumber = LottoNumber.from(InputView.inputWinningBonus());
			final WinningLotto winningLotto = WinningLotto.of(lotto, bonusLottoNumber);

			final LottoResult lottoResult = LottoResult.of(lottos, winningLotto);
			OutputView.printLottoResult(lottoResult);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e);
			run();
		}
	}
}
