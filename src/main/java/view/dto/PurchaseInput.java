package view.dto;

import domain.PurchaseAmount;

public class PurchaseInput {

    private final int purchaseAmount;

    public PurchaseInput(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseAmount toPurchaseAmount() {
        return PurchaseAmount.create(purchaseAmount);
    }
}
