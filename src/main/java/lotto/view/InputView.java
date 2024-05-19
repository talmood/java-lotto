package lotto.view;

import lotto.request.LottoPurchaseRequest;
import lotto.utils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static LottoPurchaseRequest inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return LottoPurchaseRequest.from(Console.readLine());
    }

    public static void inputLastWeekWinningNumbers() {
    }
}
