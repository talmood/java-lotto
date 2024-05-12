package validator;

public class InputValidator {
	private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 금액의 입력은 0 이상의 정수여야 합니다.";
	private static final String WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
	private static final String WINNING_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";
	private static final String WINNING_NUMBER_SPLIT_REGEX = ",";
	private static final int WINNING_NUMBER_COUNT = 6;

	public static void validateAmountNotNumber(final String amountInput) {
		try {
			Integer.parseInt(amountInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
		}
	}

	public static void validateWinningNumberInput(final String winningNumberInput) {
		String trimmedInput = winningNumberInput.trim();
		String[] splitInput = trimmedInput.split(WINNING_NUMBER_SPLIT_REGEX);

		validateWinningNumberCount(splitInput);

		for (String input : splitInput) {
			validateWinningNumber(input);
		}
	}

	private static void validateWinningNumberCount(String[] splitInput) {
		if (splitInput.length != WINNING_NUMBER_COUNT) {
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

	private static void validateWinningNumberRange(int winningNumber) {
		if (winningNumber <= 0 || winningNumber > 45) {
			throw new IllegalArgumentException(WINNING_NUMBER_NOT_NUMBER_MESSAGE);
		}
	}
}
