package controller;

import model.LottoPurchaseAmount;
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

    }

}
