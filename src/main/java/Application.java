import controller.AmountRequest;
import controller.BonusNumberRequest;
import controller.ManualNumberRequest;
import controller.WinningNumberRequest;
import domain.PhraseLottoExecutor;
import domain.RateCalculateExecutor;
import domain.WinningConfirmExecutor;
import view.InputView;
import vo.LottoNumberCollectionList;
import vo.WinningTypeCollection;

public class Application {

	public static void main(String[] args) {
		final AmountRequest amountRequest = InputView.inputAmount();
		final ManualNumberRequest manualNumberRequest = InputView.inputManual(amountRequest.getLottoAmount());
		final WinningTypeCollection winningTypeCollection = retrieveWinning(
			receivePhraseLotto(amountRequest, manualNumberRequest)
		);
		final RateCalculateExecutor rateCalculateExecutor = new RateCalculateExecutor(amountRequest, winningTypeCollection);
		rateCalculateExecutor.calculateRate();
	}

	private static LottoNumberCollectionList receivePhraseLotto(final AmountRequest amountRequest, final ManualNumberRequest manualNumberRequest) {
		PhraseLottoExecutor phraseLottoExecutor = new PhraseLottoExecutor(amountRequest, manualNumberRequest);
		phraseLottoExecutor.phraseLotto();
		return phraseLottoExecutor.pickLottoNumber();
	}

	private static WinningTypeCollection retrieveWinning(final LottoNumberCollectionList lottoNumberCollectionList) {
		WinningNumberRequest winningNumberRequest = InputView.inputWinningNumber();
		BonusNumberRequest bonusNumberRequest = InputView.inputBonusNumber();
		WinningConfirmExecutor winningConfirmExecutor = new WinningConfirmExecutor(lottoNumberCollectionList, winningNumberRequest, bonusNumberRequest);
		return winningConfirmExecutor.confirmWinningType();
	}

}