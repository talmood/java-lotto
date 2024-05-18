package view;

import controller.AmountRequest;
import controller.BonusNumberRequest;
import controller.WinningNumberRequest;
import utils.Console;
import validator.InputValidator;

public class InputView {
	private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

	public static AmountRequest inputAmount() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
		try {
			final String lottoAmountInput = Console.readLine();
			InputValidator.validateAmountNotNumber(lottoAmountInput);
			return AmountRequest.of(lottoAmountInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputAmount();
		}
	}

	public static WinningNumberRequest inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		try {
			final String winningNumberInput = Console.readLine();
			InputValidator.validateWinningNumberInput(winningNumberInput);
			return WinningNumberRequest.of(winningNumberInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputWinningNumber();
		}
	}

	public static BonusNumberRequest inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		try {
			final String bonusNumberInput = Console.readLine();
			InputValidator.validateBonusNumberInput(bonusNumberInput);
			return BonusNumberRequest.of(bonusNumberInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputBonusNumber();
		}
	}
}
