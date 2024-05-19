package view.input.dto;

import domain.ManualPurchaseCount;

public class ManualPurchaseCountInput {

    private final int manualPurchaseCount;

    public ManualPurchaseCountInput(int manualPurchaseCount) {
        this.manualPurchaseCount = manualPurchaseCount;
    }

    public ManualPurchaseCount toManualPurchaseCount() {
        return ManualPurchaseCount.create(this.manualPurchaseCount);
    }
}
