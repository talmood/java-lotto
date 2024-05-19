package view.output.dto;

import domain.LottoWinnings;
import domain.PurchaseAmount;

public class LottoWinningStatisticsOutput {

    private final LottoWinningsOutput lottoWinningOutputs;
    private final double revenueRate;

    public LottoWinningStatisticsOutput(LottoWinningsOutput lottoWinningOutputs, double revenueRate) {
        this.lottoWinningOutputs = lottoWinningOutputs;
        this.revenueRate = revenueRate;
    }

    public static LottoWinningStatisticsOutput from(LottoWinnings lottoWinnings, PurchaseAmount purchaseAmount) {
        return new LottoWinningStatisticsOutput(
                LottoWinningsOutput.from(lottoWinnings),
                new LottoRevenueRateCalculator(lottoWinnings, purchaseAmount).calculate()
        );
    }

    public LottoWinningsOutput fetchWinningsOutput() {
        return this.lottoWinningOutputs;
    }

    public double fetchRevenueRate() {
        return this.revenueRate;
    }
}
