package lotto.controller;

import lotto.domain.PurchasedLotto;
import lotto.request.LottoPurchaseRequest;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static void run() {
        final int purchaseCount = inputPurchaseAmount();
        ResultView.printPurchaseAmount(purchaseCount);
        generateLottoNumbers(purchaseCount);

    }


    private static int inputPurchaseAmount() {
        final LottoPurchaseRequest lottoPurchaseRequest = InputView.inputPurchaseAmount();
        return lottoPurchaseRequest.calculatePurchaseCount();
    }

    private static void generateLottoNumbers(final int purchaseCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        final List<PurchasedLotto> purchasedLottos = lottoGenerator.generatePurchasedLottos(purchaseCount);
        ResultView.printPurchasedLottos(purchasedLottos);
    }

    // 지난 주 당첨 번호를 입력받는 메서드
    private static void inputLastWeekWinningNumbers() {
        InputView.inputLastWeekWinningNumbers();
    }

}
