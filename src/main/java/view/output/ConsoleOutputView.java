package view.output;

import view.output.dto.LottoWinningStatisticsOutput;
import view.output.dto.LottoWinningsOutput;
import view.output.dto.LottosOutput;
import view.output.dto.PurchaseCountOutput;

public class ConsoleOutputView implements OutputView {

    private static final String PURCHASE_COUNT_NAVIGATION = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_NAVIGATION = "당첨 통계";
    private static final String WINNING_SEPARATOR = "---------";

    private static final String MATCH_WINNING_NUMBER_NAVIGATION = "%d개 일치";
    private static final String MATCH_BONUS_NUMBER_NAVIGATION = ", 보너스 볼 일치";
    private static final String WINNING_AMOUNT_NAVIGATION = " (%d원)";
    private static final String MATCH_COUNT_NAVIGATION = " - %d개";
    private static final String WINNING_REVENUE_RATE_NAVIGATION = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_LOSS_NAVIGATION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_GAIN_NAVIGATION = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOTTO_BREAK_EVEN_NAVIGATION = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";

    @Override
    public void viewPurchaseCount(PurchaseCountOutput purchaseCountOutput) {
        System.out.printf(
                PURCHASE_COUNT_NAVIGATION + "%n",
                purchaseCountOutput.fetchManualPurchaseCount(),
                purchaseCountOutput.fetchAutoPurchaseCount()
        );
    }

    @Override
    public void viewLottos(LottosOutput lottosOutput) {
        System.out.println(lottosOutput.fetchLottosNumbersStr() + "\n");
    }

    @Override
    public void viewWinningStatistics(LottoWinningStatisticsOutput lottoWinningStatisticsOutput) {
        System.out.println(WINNING_STATISTICS_NAVIGATION);
        System.out.println(WINNING_SEPARATOR);
        LottoWinningsOutput lottoWinningsOutput = lottoWinningStatisticsOutput.fetchWinningsOutput();
        double revenueRate = lottoWinningStatisticsOutput.fetchRevenueRate();
        lottoWinningsOutput.toList().forEach(
                lottoWinningOutput ->
                        System.out.printf(
                                makeWinningStatisticsNavigation(lottoWinningOutput.isMatchBonusNumber()),
                                lottoWinningOutput.fetchMatchWinningNumberCount(),
                                lottoWinningOutput.fetchWinningAmount(),
                                lottoWinningOutput.fetchMatchCount()
                        )
        );
        System.out.printf(makeRevenueNavigation(revenueRate), Math.floor(revenueRate * 100) / 100.0);
    }

    private String makeWinningStatisticsNavigation(boolean matchBonusNumber) {
        String bonusNavigation = "";

        if (matchBonusNumber) {
            bonusNavigation = MATCH_BONUS_NUMBER_NAVIGATION;
        }

        return MATCH_WINNING_NUMBER_NAVIGATION + bonusNavigation + WINNING_AMOUNT_NAVIGATION + MATCH_COUNT_NAVIGATION + "\n";
    }

    private String makeRevenueNavigation(double revenueRate) {
        String gainNavigation = "";

        if (revenueRate > 1.0) {
            gainNavigation = LOTTO_GAIN_NAVIGATION;
        }

        if (revenueRate == 1.0) {
            gainNavigation = LOTTO_BREAK_EVEN_NAVIGATION;
        }

        if (revenueRate < 1.0) {
            gainNavigation = LOTTO_LOSS_NAVIGATION;
        }

        return WINNING_REVENUE_RATE_NAVIGATION + gainNavigation;
    }
}
