package view.input;

import exception.InvalidInputException;
import util.Console;
import util.PatternMatchUtils;
import util.StringUtils;
import view.input.dto.BonusNumberInput;
import view.input.dto.PurchaseInput;
import view.input.dto.WinningNumbersInput;

import java.util.Arrays;
import java.util.stream.Collectors;

import static exception.code.ErrorCode.INVALID_NUMBERS_INPUT;
import static exception.code.ErrorCode.INVALID_NUMBER_INPUT;

public class ConsoleInputView implements InputView {

    private static final String PURCHASE_AMOUNT_NAVIGATION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_NAVIGATION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_NAVIGATION = "보너스 볼을 입력해 주세요.";
    private static final String NUMBERS_INPUT_REGEX = "^\\d{1,2}(,\\s\\d{1,2}){5}$";

    @Override
    public PurchaseInput inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_NAVIGATION);
        String input = Console.readLine();
        this.validateNumber(input);

        return new PurchaseInput(Integer.parseInt(input));
    }

    @Override
    public WinningNumbersInput inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_NAVIGATION);
        String input = Console.readLine();
        this.validateNumbers(input);

        return new WinningNumbersInput(
                Arrays.stream(input.split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public BonusNumberInput inputBonusNumber() {
        System.out.println(BONUS_NUMBER_NAVIGATION);
        String input = Console.readLine();
        this.validateNumber(input);

        return new BonusNumberInput(Integer.parseInt(input));
    }

    private void validateNumber(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new InvalidInputException(INVALID_NUMBER_INPUT, "숫자인 입력값만 허용됩니다.");
        }
    }

    private void validateNumbers(String input) {
        if (!PatternMatchUtils.matches(NUMBERS_INPUT_REGEX, input)) {
            throw new InvalidInputException(INVALID_NUMBERS_INPUT, "번호 입력 형식이 올바르지 않습니다.");
        }
    }
}
