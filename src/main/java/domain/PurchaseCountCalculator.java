package domain;

public class PurchaseCountCalculator {

    private static final int LOTTO_PRICE = 1000;

    private final PurchaseAmount purchaseAmount;

    public PurchaseCountCalculator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseCount calculate() {
        return PurchaseCount.create(this.purchaseAmount.fetchPurchaseAmount()/LOTTO_PRICE);
    }
}
