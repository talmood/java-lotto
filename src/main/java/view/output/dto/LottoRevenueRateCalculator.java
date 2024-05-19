package view.output.dto;

import domain.LottoWinnings;
import domain.PurchaseAmount;

public class LottoRevenueRateCalculator {

    private final LottoWinnings lottoWinnings;
    private final PurchaseAmount purchaseAmount;

    public LottoRevenueRateCalculator(LottoWinnings lottoWinnings, PurchaseAmount purchaseAmount) {
        this.lottoWinnings = lottoWinnings;
        this.purchaseAmount = purchaseAmount;
    }

    public double calculate() {
        long totalWinningAmount = this.lottoWinnings.sumAllWinningAmount();

        return (double) totalWinningAmount / purchaseAmount.fetchPurchaseAmount();
    }
}
