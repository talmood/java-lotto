package validator;

public class AmountValidator {

	private static final String NEGATIVE_EXCEPTION_MESSAGE = "[ERROR] 금액은 음수로 입력할 수 없습니다.";

	public static void validateAmountNegative(final int lottoAmount) {
		if (lottoAmount < 0) {
			throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
		}
	}
}
