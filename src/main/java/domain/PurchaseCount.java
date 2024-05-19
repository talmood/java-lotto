package domain;

import exception.DomainValidationException;

import static exception.code.ErrorCode.INVALID_PURCHASE_COUNT;

public abstract class PurchaseCount {

    private final int purchaseCount;

    protected PurchaseCount(int purchaseCount) {
        this.validatePurchaseCount(purchaseCount);
        this.purchaseCount = purchaseCount;
    }

    private void validatePurchaseCount(int purchaseCount) {
        if (purchaseCount < 1) {
            throw new DomainValidationException(INVALID_PURCHASE_COUNT, "구입 갯수는 1개이상이어야 합니다.");
        }
    }

    public int fetchPurchaseCount() {
        return this.purchaseCount;
    }
}
