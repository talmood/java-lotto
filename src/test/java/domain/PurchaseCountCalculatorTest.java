package domain;

import constant.LottoConstants;
import exception.DomainValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static exception.code.ErrorCode.NOT_ENOUGH_PURCHASE_AMOUNT;

class PurchaseCountCalculatorTest {

    @Test
    @DisplayName("자동 구입 갯수는 수동 구입 갯수를 제외한 나머지를 구매한다.")
    void autoPurchaseCountIsAllMinusManualPurchaseCount() {
        int purchaseAmountValue = 14000;
        int manualCountValue = 10;

        PurchaseAmount purchaseAmount = PurchaseAmount.create(purchaseAmountValue);
        PurchaseCount manualPurchaseCount = ManualPurchaseCount.create(manualCountValue);
        PurchaseCountCalculator purchaseCountCalculator = new PurchaseCountCalculator(purchaseAmount);
        AutoPurchaseCount autoPurchaseCount = purchaseCountCalculator.calculateAutoPurchaseCount(manualPurchaseCount);

        Assertions.assertEquals(
                autoPurchaseCount.fetchPurchaseCount(),
                (purchaseAmountValue - (LottoConstants.LOTTO_PRICE * manualCountValue)) / LottoConstants.LOTTO_PRICE
        );
    }

    @Test
    @DisplayName("수동 구매 금액이 구매 금액보다 큰 경우 예외를 발생시킨다.")
    void manualPurchaseGreaterThanPurchaseAmount() {
        PurchaseAmount purchaseAmount = PurchaseAmount.create(10);
        PurchaseCount manualPurchaseCount = ManualPurchaseCount.create(20);
        PurchaseCountCalculator purchaseCountCalculator = new PurchaseCountCalculator(purchaseAmount);

        DomainValidationException domainValidationException = Assertions.assertThrows(
                DomainValidationException.class,
                () -> purchaseCountCalculator.calculateAutoPurchaseCount(manualPurchaseCount)
        );
        Assertions.assertSame(domainValidationException.fetchErrorCode(), NOT_ENOUGH_PURCHASE_AMOUNT);
    }


}