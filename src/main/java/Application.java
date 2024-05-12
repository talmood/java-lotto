import controller.AmountRequest;
import controller.WinningNumberRequest;
import domain.PhraseLottoExecutor;
import view.InputView;
import vo.LottoNumberCollectionList;

public class Application {

	public static void main(String[] args) {
		AmountRequest amountRequest = InputView.inputAmount();
		PhraseLottoExecutor phraseLottoExecutor = new PhraseLottoExecutor(amountRequest);
		phraseLottoExecutor.phraseLotto();
		LottoNumberCollectionList lottoNumberCollectionList = phraseLottoExecutor.pickLottoNumber();

		WinningNumberRequest winningNumberRequest = InputView.inputWinningNumber();

	}

}