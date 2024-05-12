package view;

import controller.AmountRequest;
import utils.Console;
import validator.InputValidator;

public class InputView {
	private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

	public static AmountRequest inputAmount() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
		try {
			String amountInput = Console.readLine();
			InputValidator.validateAmountNotNumber(amountInput);
			return AmountRequest.of(Integer.parseInt(amountInput));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputAmount();
		}
	}
}
