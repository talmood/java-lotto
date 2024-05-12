import controller.AmountRequest;
import domain.PhraseLottoExecutor;
import view.InputView;

public class Application {

	public static void main(String[] args) {
		AmountRequest amountRequest = InputView.inputAmount();
		PhraseLottoExecutor phraseLottoExecutor = new PhraseLottoExecutor(amountRequest);
		phraseLottoExecutor.phraseLotto();
		phraseLottoExecutor.pickLottoNumber();
	}

}