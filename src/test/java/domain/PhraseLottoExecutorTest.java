package domain;

import controller.AmountRequest;
import controller.ManualNumberRequest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PhraseLottoExecutorTest extends IOTest {
	private static final String PHRASE_LOTTO_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";

	@Test
	void 로또_구입_메시지_출력을_확인한다() {
		PhraseLottoExecutor sut = new PhraseLottoExecutor(createAmountRequest(), createManualNumberRequest());

		sut.phraseLotto();

		assertThat(fetchOutput()).contains(String.format(PHRASE_LOTTO_MESSAGE, 1, 4));
	}

	private AmountRequest createAmountRequest() {
		String amountInput = "5000";
		return AmountRequest.from(amountInput);
	}

	private ManualNumberRequest createManualNumberRequest() {
		int manualCount = 1;
		List<String> manualNumberInputs = List.of("1, 2, 3, 4, 5, 6");
		return ManualNumberRequest.of(manualCount, manualNumberInputs);
	}
}