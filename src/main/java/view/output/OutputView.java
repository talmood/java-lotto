package view.output;

import view.output.dto.LottoWinningStatisticsOutput;
import view.output.dto.LottosOutput;
import view.output.dto.PurchaseOutput;

public interface OutputView {

    void viewPurchaseAmount(PurchaseOutput purchaseOutput);

    void viewLottos(LottosOutput lottosOutput);

    void viewWinningStatistics(LottoWinningStatisticsOutput lottoWinningStatisticsOutput);
}
