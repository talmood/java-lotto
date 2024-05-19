package view;

import model.LottoPurchaseAmount;
import utils.NumericUtils;

public class InputLottoPurchaseAmount {

    private final int amount;

    private InputLottoPurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static InputLottoPurchaseAmount fromAmountString(String amount) {
        if (!NumericUtils.isNumericString(amount)) {
            throw new IllegalArgumentException("로또 구매 금액은 숫자여야합니다.");
        }
        return new InputLottoPurchaseAmount(Integer.parseInt(amount));
    }

    public LottoPurchaseAmount toLottoPurchaseAmount() {
        return new LottoPurchaseAmount(this.amount);
    }

}
