package controller;

import model.*;
import model.lottonumber.LottoNumberGeneratorImpl;
import view.InputView;
import view.ResultView;

public class LottoGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        final LottoPurchaseAmount purchaseAmount = inputView.inputLottoPurchaseAmount();
        final LottoTicket lottoTicket1 = LottoTicketSeller.getInstance().buyLottoTicket(purchaseAmount, new LottoNumberGeneratorImpl());
        resultView.showPurchasedLottoTicket(lottoTicket1);

        final LottoWinningNumbers winningNumbers = inputWinningNumbers();
        final LottoWinningResult winningResult = winningNumbers.calculateWinningResult(lottoTicket1);

        resultView.showLottoWinningResult(winningResult);

        resultView.showProfit(winningResult.confirmProfit(purchaseAmount));
    }

    private LottoWinningNumbers inputWinningNumbers() {
        final LottoWinningGame winningGame = inputView.inputLottoWinningGame();
        final LottoBonusNumber bonusNumber = inputView.inputLottoBonusNumber();

        return new LottoWinningNumbers(winningGame, bonusNumber);
    }

}
