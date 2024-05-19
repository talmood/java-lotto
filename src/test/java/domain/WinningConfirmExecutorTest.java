package domain;

import controller.BonusNumberRequest;
import controller.WinningNumberRequest;
import org.junit.jupiter.api.Test;
import vo.LottoNumberCollection;
import vo.LottoNumberCollectionList;
import vo.enums.WinningType;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningConfirmExecutorTest extends IOTest {

	private static final String WINNING_FORMAT = "%s - %d개";

	@Test
	void 당첨_금액_통계_출력_확인하기() {
		WinningConfirmExecutor sut = new WinningConfirmExecutor(createLottoNumberCollectionList(),
																createWinningNumberRequest(),
																createBonusNumberRequest());

		sut.confirmWinningType();

		assertAll(
			() -> assertThat(fetchOutput()).contains(String.format(WINNING_FORMAT, WinningType.THREE_MATCH.getTitle(), 1)),
			() -> assertThat(fetchOutput()).contains(String.format(WINNING_FORMAT, WinningType.FOUR_MATCH.getTitle(), 1)),
			() -> assertThat(fetchOutput()).contains(String.format(WINNING_FORMAT, WinningType.FIVE_BONUS_MATCH.getTitle(), 1))
		);
	}

	private LottoNumberCollectionList createLottoNumberCollectionList() {
		return LottoNumberCollectionList.from(createLottoNumberCollection());
	}

	private List<LottoNumberCollection> createLottoNumberCollection() {
		List<Integer> pickLottoNumbers1 = List.of(1, 2, 3, 8, 9, 10);
		List<Integer> pickLottoNumbers2 = List.of(1, 2, 3, 4, 8, 9);
		List<Integer> pickLottoNumbers3 = List.of(1, 2, 3, 4, 5, 7);

		List<List<Integer>> pickLottoNumberList = List.of(pickLottoNumbers1, pickLottoNumbers2, pickLottoNumbers3);
		return pickLottoNumberList.stream()
			.map(LottoNumberCollection::from)
			.collect(Collectors.toList());
	}

	private WinningNumberRequest createWinningNumberRequest() {
		String winningNumberInput = "1, 2, 3, 4, 5, 6";
		return WinningNumberRequest.from(winningNumberInput);
	}

	private BonusNumberRequest createBonusNumberRequest() {
		String bonusNumberInput = "7";
		return BonusNumberRequest.from(bonusNumberInput);
	}
}