package view.output.dto;

import domain.PurchaseCount;

public abstract class PurchaseOutputCreator {

    public static PurchaseOutput create(PurchaseCount purchaseCount) {
        return new PurchaseOutput(purchaseCount.fetchPurchaseCount());
    }
}
