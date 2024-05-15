package domain;

import exception.DomainValidationException;
import view.output.dto.PurchaseOutput;

import static exception.code.ErrorCode.*;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    private final int purchaseCount;

    private PurchaseAmount(int purchaseAmount, int purchaseCount) {
        this.validatePurchaseCount(purchaseCount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseCount;
    }

    public static PurchaseAmount create(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount, purchaseAmount/LOTTO_PRICE);
    }

    private void validatePurchaseCount(int purchaseCount) {
        if(purchaseCount < 1) {
            throw new DomainValidationException(PURCHASE_COUNT_BIGGER_THAN_ZERO, "구입 갯수는 1개이상이어야 합니다.");
        }
    }

    public PurchaseOutput toPurchaseOutput() {
        return new PurchaseOutput(this.purchaseCount);
    }
}
