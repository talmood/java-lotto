package domain;

import exception.DomainValidationException;

import static exception.code.ErrorCode.*;

public class PurchaseAmount {

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        this.validateAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount create(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int fetchPurchaseAmount() {
        return this.purchaseAmount;
    }

    private void validateAmount(int purchaseAmount) {
        if(purchaseAmount <= 0) {
            throw new DomainValidationException(INVALID_PURCHASE_AMOUNT, "구입 금액은 0보다 커야합니다.");
        }
    }
}
