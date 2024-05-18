package view;

import vo.LottoNumberCollection;
import vo.LottoNumberCollectionList;
import vo.WinningTypeCollection;
import vo.enums.WinningType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
	private static final String PHRASE_LOTTO_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
	private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---------";
	private static final String TOTAL_RATE_MESSAGE = "총 수익률은 %.2f입니다.";
	private static final String SQUARE_BRACKETS_FOR_LOTTO_NUMBER = "[%s]";
	private static final String REST_DELIMITER = ", ";
	private static final String WINNING_FORMAT = "%s - %d개";

	public static void outputPhraseLotto(final int manualCount, final int randomCount) {
		System.out.println(String.format(PHRASE_LOTTO_MESSAGE, manualCount, randomCount));
	}

	public static void outputPickedLottoNumber(final LottoNumberCollectionList lottoNumberCollectionList) {
		List<LottoNumberCollection> lottoNumberCollections = lottoNumberCollectionList.getLottoNumberCollectionList();
		lottoNumberCollections.forEach(lottoNumberCollection -> {
			String collectPickLottoNumber = lottoNumberCollection.getPickLottoNumbers().stream()
				.map(Object::toString)
				.collect(Collectors.joining(REST_DELIMITER));

			System.out.println(String.format(SQUARE_BRACKETS_FOR_LOTTO_NUMBER, collectPickLottoNumber));
		});
	}

	public static void outputLottoWinningPrice(final WinningTypeCollection winningTypeCollection) {
		Map<WinningType, Long> winningTypeVsMatchCountMap = winningTypeCollection.fetchMapOfWinningTypeVsMatchCount();
		System.out.println(WINNING_STATISTICS_MESSAGE);

		for (WinningType winningType : winningTypeCollection.getAllWinningType()) {
			System.out.println(String.format(WINNING_FORMAT, winningType.getTitle(), winningTypeVsMatchCountMap.get(winningType)));
		}
	}

	public static void outputRateOfReturn(final double rate) {
		System.out.println(String.format(TOTAL_RATE_MESSAGE, rate));
	}

}
