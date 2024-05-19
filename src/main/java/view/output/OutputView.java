package view.output;

import view.output.dto.LottoWinningStatisticsOutput;
import view.output.dto.LottosOutput;
import view.output.dto.PurchaseCountOutput;

public interface OutputView {

    void viewPurchaseCount(PurchaseCountOutput purchaseCountOutput);

    void viewLottos(LottosOutput lottosOutput);

    void viewWinningStatistics(LottoWinningStatisticsOutput lottoWinningStatisticsOutput);
}
