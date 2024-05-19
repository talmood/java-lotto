package view.input.dto;

import domain.PurchaseAmount;
import exception.DomainValidationException;

import static exception.code.ErrorCode.INVALID_PURCHASE_AMOUNT;

public class PurchaseInput {

    private final int purchaseAmount;

    public PurchaseInput(int purchaseAmount) {
        this.validateAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseAmount toPurchaseAmount() {
        return PurchaseAmount.create(purchaseAmount);
    }

    private void validateAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new DomainValidationException(INVALID_PURCHASE_AMOUNT, "구입 금액은 0보다 커야합니다.");
        }
    }
}
