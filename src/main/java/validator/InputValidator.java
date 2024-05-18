package validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
	private static final String AMOUNT_NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 금액의 입력은 0 이상의 정수여야 합니다.";
	private static final String MANUAL_COUNT_NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 수동으로 구매할 로또 수의 입력은 0 이상의 정수여야 합니다.";
	private static final String MANUAL_COUNT_NOT_BIGGER_EXCEPTION_MESSAGE = "[ERROR] 수동으로 구매할 로또 수는 구매한 로또 수보다 클 수 없습니다.";
	private static final String MANUAL_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 수동으로 구매할 번호는 6개여야 합니다.";
	private static final String MANUAL_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 수동으로 구매할 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";
	private static final String WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
	private static final String WINNING_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";
	private static final String BONUS_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 보너스 볼 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";
	private static final String NUMBER_INPUT_SPLIT_REGEX = ",";
	private static final int LOTTO_NUMBER_COUNT = 6;

	public static void validateAmountNotNumber(final String amountInput) {
		try {
			Integer.parseInt(amountInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(AMOUNT_NOT_NUMBER_EXCEPTION_MESSAGE);
		}
	}

	public static void validateManualCountNotNumber(final String manualCountInput, final int lottoAmount) {
		try {
			int manualCount = Integer.parseInt(manualCountInput);
			validateManualCountLeastThanLottoAmount(lottoAmount, manualCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MANUAL_COUNT_NOT_NUMBER_EXCEPTION_MESSAGE);
		}
	}

	private static void validateManualCountLeastThanLottoAmount(int lottoAmount, int manualCount) {
		if (manualCount > lottoAmount) {
			throw new IllegalArgumentException(MANUAL_COUNT_NOT_BIGGER_EXCEPTION_MESSAGE);
		}
	}

	public static void validateManualNumberInput(final List<String> manualNumberInputs) {
		manualNumberInputs.forEach(manualNumberInput -> {
			String[] splitInput = manualNumberInput
				.replaceAll(" ", "")
				.split(NUMBER_INPUT_SPLIT_REGEX);

			if (splitInput.length != LOTTO_NUMBER_COUNT) {
				throw new IllegalArgumentException(MANUAL_NUMBER_COUNT_EXCEPTION_MESSAGE);
			}

			validateManualNumber(splitInput);
		});
	}

	private static void validateManualNumber(String[] splitInput) {
		try {
			Arrays.stream(splitInput)
				.map(Integer::parseInt)
				.forEach(InputValidator::validateManualNumberRange);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MANUAL_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}

	private static void validateManualNumberRange(final int manualNumber) {
		if (!isLottoNumberRange(manualNumber)) {
			throw new IllegalArgumentException(MANUAL_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}

	public static void validateWinningNumberInput(final String winningNumberInput) {
		String[] splitInput = winningNumberInput
			.replaceAll(" ", "")
			.split(NUMBER_INPUT_SPLIT_REGEX);

		validateWinningNumberCount(splitInput);

		for (String input : splitInput) {
			validateWinningNumber(input);
		}
	}

	private static void validateWinningNumberCount(final String[] splitInput) {
		if (splitInput.length != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE);
		}
	}

	private static void validateWinningNumber(final String input) {
		try {
			int winningNumber = Integer.parseInt(input);
			validateWinningNumberRange(winningNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(WINNING_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}

	private static void validateWinningNumberRange(final int winningNumber) {
		if (!isLottoNumberRange(winningNumber)) {
			throw new IllegalArgumentException(WINNING_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}

	private static boolean isLottoNumberRange(final int number) {
		return number > 0 && number < 46;
	}

	public static void validateBonusNumberInput(final String bonusNumberInput) {
		try {
			int bonusNumber = Integer.parseInt(bonusNumberInput);

			validateBonusNumberRange(bonusNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}

	private static void validateBonusNumberRange(final int bonusNumber) {
		if (!isLottoNumberRange(bonusNumber)) {
			throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}
}
