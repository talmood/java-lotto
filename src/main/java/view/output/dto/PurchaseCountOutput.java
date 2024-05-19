package view.output.dto;

import domain.PurchaseCount;

public class PurchaseCountOutput {

    private final int manualPurchaseCount;
    private final int autoPurchaseCount;

    private PurchaseCountOutput(int manualPurchaseCount, int autoPurchaseCount) {
        this.manualPurchaseCount = manualPurchaseCount;
        this.autoPurchaseCount = autoPurchaseCount;
    }

    public static PurchaseCountOutput of(PurchaseCount manualPurchaseCount, PurchaseCount autoPurchaseCount) {
        return new PurchaseCountOutput(manualPurchaseCount.fetchPurchaseCount(), autoPurchaseCount.fetchPurchaseCount());
    }

    public int fetchManualPurchaseCount() {
        return this.manualPurchaseCount;
    }

    public int fetchAutoPurchaseCount() {
        return this.autoPurchaseCount;
    }
}
