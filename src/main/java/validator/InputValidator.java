package validator;

public class InputValidator {
	private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 금액의 입력은 0 이상의 정수여야 합니다.";

	public static void validateAmountNotNumber(final String amountInput) {
		try {
			Integer.parseInt(amountInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
		}
	}
}
