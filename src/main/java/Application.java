import controller.AmountRequest;
import controller.BonusNumberRequest;
import controller.WinningNumberRequest;
import domain.PhraseLottoExecutor;
import domain.RateCalculateExecutor;
import domain.WinningConfirmExecutor;
import view.InputView;
import vo.LottoNumberCollectionList;
import vo.WinningTypeCollection;

public class Application {

	public static void main(String[] args) {
		AmountRequest amountRequest = InputView.inputAmount();

		WinningTypeCollection winningTypeCollection = retrieveWinning(receivePhraseLotto(amountRequest));

		RateCalculateExecutor rateCalculateExecutor = new RateCalculateExecutor(amountRequest, winningTypeCollection);
		rateCalculateExecutor.calculateRate();
	}

	private static LottoNumberCollectionList receivePhraseLotto(final AmountRequest amountRequest) {
		PhraseLottoExecutor phraseLottoExecutor = new PhraseLottoExecutor(amountRequest);
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