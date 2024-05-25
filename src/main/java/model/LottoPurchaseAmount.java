package model;

public record LottoPurchaseAmount(
        int amount
) {

    private static final int MIN_AMOUNT = 1000;
    private static final int AMOUNT_UNIT = 1000;

    public LottoPurchaseAmount {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또 구매 금액은 최소 1000원 이상이어야합니다.");
        }
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1000원 단위여야합니다.");
        }

    }

    public int calculateGameSize() {
        return this.amount / AMOUNT_UNIT;
    }

}
