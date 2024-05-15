package domain;

import exception.DomainValidationException;
import view.output.dto.PurchaseOutput;

import static exception.code.ErrorCode.INVALID_PURCHASE_COUNT;

public class PurchaseCount {

    private final int purchaseCount;

    private PurchaseCount(int purchaseCount) {
        this.validatePurchaseCount(purchaseCount);
        this.purchaseCount = purchaseCount;
    }

    public static PurchaseCount create(int purchaseCount) {
        return new PurchaseCount(purchaseCount);
    }

    private void validatePurchaseCount(int purchaseCount) {
        if(purchaseCount < 1) {
            throw new DomainValidationException(INVALID_PURCHASE_COUNT, "구입 갯수는 1개이상이어야 합니다.");
        }
    }

    public PurchaseOutput toPurchaseOutput() {
        return new PurchaseOutput(this.purchaseCount);
    }

    public int fetchPurchaseCount() {
        return this.purchaseCount;
    }
}
