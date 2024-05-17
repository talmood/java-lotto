package view.output.dto;

import domain.PurchaseCount;

public class PurchaseOutput {

    private final int purchaseCount;

    public PurchaseOutput(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public static PurchaseOutput from(PurchaseCount purchaseCount) {
        return new PurchaseOutput(purchaseCount.fetchPurchaseCount());
    }

    public int fetchPurchaseCount() {
        return this.purchaseCount;
    }
}
