package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.PurchasedLotto;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeResult;
import lotto.view.printer.PrizePrinterFactory;
import lotto.view.printer.PrizePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---------";
    private static final String TOTAL_EARNING_RATE = "총 수익률은 %.2f입니다.";

    private ResultView() {
    }

    public static void printPurchaseAmount(final int purchaseAmount) {
        System.out.println(String.format(PURCHASE_AMOUNT_MESSAGE, purchaseAmount));
    }

    public static void printPurchasedLottos(final List<PurchasedLotto> purchasedLottos) {
        purchasedLottos.forEach(ResultView::printPurchasedLotto);
    }

    private static void printPurchasedLotto(final PurchasedLotto purchasedLotto) {
        final List<Integer> lottoNumbers = new ArrayList<>(purchasedLotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .toList());

        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }

    public static void printWinningStatistics(final PrizeResult prizeResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(WINNING_STATISTICS_SEPARATOR);

        prizeResult.getPrizeCounts().forEach((prize, count) -> {
            if (prize == Prize.NONE) {
                return;
            }

            final PrizePrinter prizePrinter = PrizePrinterFactory.generatePrinter(prize);
            prizePrinter.print(prize.getMatchCount(), prize.getMoney(), count);
        });

        System.out.println(String.format(TOTAL_EARNING_RATE, prizeResult.calculateEarningRate()));
    }
}