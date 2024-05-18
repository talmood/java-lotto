package validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {
	private static final String AMOUNT_NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 금액의 입력은 0 이상의 정수여야 합니다.";
	private static final String MANUAL_COUNT_NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 수동으로 구매할 로또 수의 입력은 0 이상의 정수여야 합니다.";
	private static final String MANUAL_COUNT_NOT_BIGGER_EXCEPTION_MESSAGE = "[ERROR] 수동으로 구매할 로또 수는 구매한 로또 수보다 클 수 없습니다.";
	private static final String MANUAL_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 수동으로 구매할 번호는 6개여야 합니다.";
	private static final String MANUAL_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 수동으로 구매할 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";
	private static final String WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
	private static final String WINNING_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";
	private static final String BONUS_NUMBER_NOT_NUMBER_MESSAGE = "[ERROR] 보너스 볼 번호는 1부터 45까지의 숫자로 이루어져야 합니다.";

	@Test
	void 구매한_로또_개수_입력_유효성을_검사한다() {
		String alphabetInput = "a";
		String koreanInput = "가";

		IllegalArgumentException actual1 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmountNotNumber(alphabetInput));
		IllegalArgumentException actual2 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmountNotNumber(koreanInput));

		assertAll(
			() -> assertThat(actual1.getMessage()).isEqualTo(AMOUNT_NOT_NUMBER_EXCEPTION_MESSAGE),
			() -> assertThat(actual2.getMessage()).isEqualTo(AMOUNT_NOT_NUMBER_EXCEPTION_MESSAGE)
		);
	}

	@Test
	void 수동_구매_개수_입력_유효성을_검사한다() {
		String alphabetInput = "a";
		String koreanInput = "가";
		String manualCount = "6";
		int lottoAmount = 5;

		IllegalArgumentException actual1 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualCountNotNumber(alphabetInput, lottoAmount));
		IllegalArgumentException actual2 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualCountNotNumber(koreanInput, lottoAmount));
		IllegalArgumentException actual3 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualCountNotNumber(manualCount, lottoAmount));

		assertAll(
			() -> assertThat(actual1.getMessage()).isEqualTo(MANUAL_COUNT_NOT_NUMBER_EXCEPTION_MESSAGE),
			() -> assertThat(actual2.getMessage()).isEqualTo(MANUAL_COUNT_NOT_NUMBER_EXCEPTION_MESSAGE),
			() -> assertThat(actual3.getMessage()).isEqualTo(MANUAL_COUNT_NOT_BIGGER_EXCEPTION_MESSAGE)
		);
	}

	@Test
	void 수동으로_구매한_로또_번호_유효성을_검사한다() {
		List<String> alphabetInputs = List.of("a, b, c, d, e, f");
		List<String> koreanInputs = List.of("가, 나, 다, 라, 마, 바");
		List<String> manyNumberInputs = List.of("1, 2, 3, 4, 5, 6, 7");
		List<String> fewNumberInputs = List.of("1, 2, 3, 4, 5");
		List<String> outRangeNumberInputs = List.of("41, 42, 43 ,44 ,45 ,46");

		IllegalArgumentException actual1 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualNumberInput(alphabetInputs));
		IllegalArgumentException actual2 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualNumberInput(koreanInputs));
		IllegalArgumentException actual3 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualNumberInput(manyNumberInputs));
		IllegalArgumentException actual4 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualNumberInput(fewNumberInputs));
		IllegalArgumentException actual5 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateManualNumberInput(outRangeNumberInputs));

		assertAll(
			() -> assertThat(actual1.getMessage()).isEqualTo(MANUAL_NUMBER_NOT_NUMBER_MESSAGE),
			() -> assertThat(actual2.getMessage()).isEqualTo(MANUAL_NUMBER_NOT_NUMBER_MESSAGE),
			() -> assertThat(actual3.getMessage()).isEqualTo(MANUAL_NUMBER_COUNT_EXCEPTION_MESSAGE),
			() -> assertThat(actual4.getMessage()).isEqualTo(MANUAL_NUMBER_COUNT_EXCEPTION_MESSAGE),
			() -> assertThat(actual5.getMessage()).isEqualTo(MANUAL_NUMBER_NOT_NUMBER_MESSAGE)
		);
	}

	@Test
	void 저번_당첨번호_입력_유효성을_검사한다() {
		String alphabetInput = "a, b, c, d, e, f";
		String koreanInput = "가, 나, 다, 라, 마, 바";
		String manyNumberInput = "1, 2, 3, 4, 5, 6, 7";
		String fewNumberInput = "1, 2, 3, 4, 5";
		String outRangeInput = "41, 42, 43, 44, 45, 46";

		IllegalArgumentException actual1 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumberInput(alphabetInput));
		IllegalArgumentException actual2 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumberInput(koreanInput));
		IllegalArgumentException actual3 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumberInput(manyNumberInput));
		IllegalArgumentException actual4 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumberInput(fewNumberInput));
		IllegalArgumentException actual5 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumberInput(outRangeInput));

		assertAll(
			() -> assertThat(actual1.getMessage()).isEqualTo(WINNING_NUMBER_NOT_NUMBER_MESSAGE),
			() -> assertThat(actual2.getMessage()).isEqualTo(WINNING_NUMBER_NOT_NUMBER_MESSAGE),
			() -> assertThat(actual3.getMessage()).isEqualTo(WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE),
			() -> assertThat(actual4.getMessage()).isEqualTo(WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE),
			() -> assertThat(actual5.getMessage()).isEqualTo(WINNING_NUMBER_NOT_NUMBER_MESSAGE)
		);
	}

	@Test
	void 보너스_번호_입력_유효성을_검사한다() {
		String alphabetInput = "a";
		String koreanInput = "가";
		String outRangeInput = "46";

		IllegalArgumentException actual1 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateBonusNumberInput(alphabetInput));
		IllegalArgumentException actual2 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateBonusNumberInput(koreanInput));
		IllegalArgumentException actual3 = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateBonusNumberInput(outRangeInput));

		assertAll(
			() -> assertThat(actual1.getMessage()).isEqualTo(BONUS_NUMBER_NOT_NUMBER_MESSAGE),
			() -> assertThat(actual2.getMessage()).isEqualTo(BONUS_NUMBER_NOT_NUMBER_MESSAGE),
			() -> assertThat(actual3.getMessage()).isEqualTo(BONUS_NUMBER_NOT_NUMBER_MESSAGE)
		);
	}

}