package domain;

import static constant.LottoConstants.LOTTO_PRICE;

public class PurchaseCountCalculator {

    private final PurchaseAmount purchaseAmount;

    public PurchaseCountCalculator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseCount calculate() {
        return PurchaseCount.create(this.purchaseAmount.fetchPurchaseAmount() / LOTTO_PRICE);
    }
}
