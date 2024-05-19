package lotto.request;

import lotto.utils.PatternUtil;

public class LottoPurchaseRequest {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int UNIT_PURCHASE_AMOUNT = 1000;
    private static final String PURCHASE_AMOUNT_REGEX = "^[0-9]*$";

    private static final String ERROR_PURCHASE_AMOUNT_NOT_A_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT_TOO_LOW = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000 = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    private final int purchaseAmount;

    private LottoPurchaseRequest(final int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoPurchaseRequest of(final String purchaseAmount) {
        validate(purchaseAmount);
        return new LottoPurchaseRequest(Integer.parseInt(purchaseAmount));
    }

    private static void validate (final String purchaseAmount) {
        validateInputPattern(purchaseAmount);
        validatePurchaseAmount(Integer.parseInt(purchaseAmount));
    }

    private static void validateInputPattern(final String purchaseAmount) {
        if (!PatternUtil.isMatched(purchaseAmount, PURCHASE_AMOUNT_REGEX)) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NOT_A_NUMBER);
        }
    }

    private static void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_TOO_LOW);
        }

        if (purchaseAmount % UNIT_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000);
        }
    }

    public int getPurchaseCount() {
        return purchaseAmount / UNIT_PURCHASE_AMOUNT;
    }

}
