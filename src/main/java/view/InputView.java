package view;

import controller.AmountRequest;
import controller.BonusNumberRequest;
import controller.ManualNumberRequest;
import controller.WinningNumberRequest;
import utils.Console;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputView {
	private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

	public static AmountRequest inputAmount() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
		try {
			final String lottoAmountInput = Console.readLine();
			InputValidator.validateAmountNotNumber(lottoAmountInput);
			return AmountRequest.from(lottoAmountInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputAmount();
		}
	}

	public static ManualNumberRequest inputManual() {
		System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
		try {
			return fetchManualNumberRequest();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputManual();
		}
	}

	private static ManualNumberRequest fetchManualNumberRequest() {
		List<String> manualNumberInputs = new ArrayList<>();

		final String manualCountInput = Console.readLine();
		InputValidator.validateManualCountNotNumber(manualCountInput);
		final int manualCount = Integer.parseInt(manualCountInput);

		System.out.println(INPUT_MANUAL_NUMBER_MESSAGE);
		IntStream.range(0, manualCount).forEach(value -> manualNumberInputs.add(Console.readLine()));
		InputValidator.validateManualNumberInput(manualNumberInputs);
		return ManualNumberRequest.of(manualCount, manualNumberInputs);
	}

	public static WinningNumberRequest inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		try {
			final String winningNumberInput = Console.readLine();
			InputValidator.validateWinningNumberInput(winningNumberInput);
			return WinningNumberRequest.from(winningNumberInput);
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
			return BonusNumberRequest.from(bonusNumberInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputBonusNumber();
		}
	}
}
