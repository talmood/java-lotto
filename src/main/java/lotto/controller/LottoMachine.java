package lotto.controller;

import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.domain.prize.PrizeResult;
import lotto.request.LastWeekWinningLottoRequest;
import lotto.request.LottoPurchaseRequest;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static void run() {
        final int purchaseCount = inputPurchaseAmount();
        printPurchaseAmount(purchaseCount);
        final List<PurchasedLotto> purchasedLottos = generateLottoNumbers(purchaseCount);

        final WinningLotto winningLotto = inputLastWeekWinningNumbers();

        printWinningStatistics(purchasedLottos, winningLotto);
    }

    private static int inputPurchaseAmount() {
        final LottoPurchaseRequest lottoPurchaseRequest = InputView.inputPurchaseAmount();
        return lottoPurchaseRequest.calculatePurchaseCount();
    }

    private static List<PurchasedLotto> generateLottoNumbers(final int purchaseCount) {
        final LottoGenerator lottoGenerator = new LottoGenerator();
        final List<PurchasedLotto> purchasedLottos = lottoGenerator.generatePurchasedLottos(purchaseCount);
        ResultView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static WinningLotto inputLastWeekWinningNumbers() {
        final LastWeekWinningLottoRequest lastWeekWinningLottoRequest = InputView.inputLastWeekWinningNumbers();
        return lastWeekWinningLottoRequest.generateWinningLotto();
    }

    private static void printPurchaseAmount(final int purchaseAmount) {
        ResultView.printPurchaseAmount(purchaseAmount);
    }

    private static void printWinningStatistics(final List<PurchasedLotto> purchasedLottos, final WinningLotto winningLotto) {
        final PrizeResult prizeResult = PrizeResult.from(purchasedLottos, winningLotto);
        ResultView.printWinningStatistics(prizeResult);
    }

}
