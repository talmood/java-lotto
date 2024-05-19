package controller;

import model.*;
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
        final LottoTicket lottoTicket = purchaseLottoTicket();

        final LottoWinningNumbers winningNumbers = inputWinningNumbers();

        final LottoWinningResult winningResult = winningNumbers.calculateWinningResult(lottoTicket);
    }

    private LottoTicket purchaseLottoTicket() {
        final LottoPurchaseAmount purchaseAmount = inputView.inputLottoPurchaseAmount();
        final LottoTicket lottoTicket = LottoTicketSeller.getInstance().buyLottoTicket(purchaseAmount, new LottoNumberGeneratorImpl());
        resultView.showPurchasedLottoTicket(lottoTicket);

        return lottoTicket;
    }

    private LottoWinningNumbers inputWinningNumbers() {
        final LottoWinningGame winningGame = inputView.inputLottoWinningGame();
        final LottoBonusNumber bonusNumber = inputView.inputLottoBonusNumber();

        return new LottoWinningNumbers(winningGame, bonusNumber);
    }

}
