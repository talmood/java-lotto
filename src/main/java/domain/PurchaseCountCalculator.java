package domain;

import exception.DomainValidationException;
import exception.code.ErrorCode;

import static constant.LottoConstants.LOTTO_PRICE;

public class PurchaseCountCalculator {

    private final PurchaseAmount purchaseAmount;

    public PurchaseCountCalculator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public AutoPurchaseCount calculateAutoPurchaseCount(PurchaseCount manualPurchaseCount) {
        this.validateEnablePurchaseAmount(manualPurchaseCount);

        return AutoPurchaseCount.create(
                this.purchaseAmount.fetchPurchaseAmount() / LOTTO_PRICE - manualPurchaseCount.fetchPurchaseCount()
        );
    }

    private void validateEnablePurchaseAmount(PurchaseCount purchaseCount) {
        if (this.purchaseAmount.isLowerThan(LOTTO_PRICE * purchaseCount.fetchPurchaseCount())) {
            throw new DomainValidationException(ErrorCode.NOT_ENOUGH_PURCHASE_AMOUNT, "구입 금액이 부족합니다.");
        }
    }
}
