package model;

public class LottoProfit {

    private final double profit;

    private LottoProfit(double profit) {
        this.profit = profit;
    }

    public static LottoProfit of(
            LottoPurchaseAmount purchaseAmount,
            long prizeAmount
    ) {
        final double profit = (double) prizeAmount / purchaseAmount.amount();
        return new LottoProfit(profit);
    }

    public double profit() {
        return profit;
    }

}
