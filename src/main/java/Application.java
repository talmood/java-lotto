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
		PhraseLottoExecutor phraseLottoExecutor = new PhraseLottoExecutor(amountRequest);
		phraseLottoExecutor.phraseLotto();
		LottoNumberCollectionList lottoNumberCollectionList = phraseLottoExecutor.pickLottoNumber();

		WinningNumberRequest winningNumberRequest = InputView.inputWinningNumber();
		BonusNumberRequest bonusNumberRequest = InputView.inputBonusNumber();
		WinningConfirmExecutor winningConfirmExecutor = new WinningConfirmExecutor(lottoNumberCollectionList, winningNumberRequest, bonusNumberRequest);
		WinningTypeCollection winningTypeCollection = winningConfirmExecutor.confirmWinningType();

		RateCalculateExecutor rateCalculateExecutor = new RateCalculateExecutor(amountRequest, winningTypeCollection);
		rateCalculateExecutor.calculateRate();
	}

}