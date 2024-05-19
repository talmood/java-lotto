package lotto.request;

import lotto.utils.PatternUtil;

import static lotto.constrant.LottoConstant.LOTTO_PRICE;

public class LottoPurchaseRequest {
    private static final String PURCHASE_AMOUNT_REGEX = "^[0-9]*$";

    private static final String ERROR_PURCHASE_AMOUNT_NOT_A_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT_TOO_LOW = "[ERROR] 구입 금액은 %d원 이상이어야 합니다.";
    private static final String ERROR_PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE = "[ERROR] 로또 구입 금액은 %d원 단위여야 합니다.";


    private final int purchaseAmount;

    private LottoPurchaseRequest(final int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoPurchaseRequest from(final String purchaseAmount) {
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
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_TOO_LOW.formatted(LOTTO_PRICE));
        }

        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.formatted(LOTTO_PRICE));
        }
    }

    public int calculatePurchaseCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

}
