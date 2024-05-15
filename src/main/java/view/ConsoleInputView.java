package view;

import exception.InvalidInputException;
import exception.code.ErrorCode;
import util.Console;
import util.StringUtils;
import view.dto.PurchaseInput;

import static exception.code.ErrorCode.*;

public class ConsoleInputView implements InputView{

    private static final String PURCHASE_AMOUNT_NAVIGATION = "구입금액을 입력해 주세요.";

    @Override
    public PurchaseInput inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_NAVIGATION);
        String input = Console.readLine();
        this.validateNumber(input);

        return new PurchaseInput(Integer.parseInt(input));
    }

    @Override
    public void inputWinningNumbers() {

    }

    @Override
    public void inputBonusNumber() {

    }

    private void validateNumber(String input) {
        if(!StringUtils.isNumeric(input)) {
            throw new InvalidInputException(ONLY_NUMBER_INPUT);
        }
    }
}
