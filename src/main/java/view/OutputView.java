package view;

import vo.LottoNumberCollection;
import vo.WinningTypeCollection;
import vo.enums.WinningType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
	private static final String PHRASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";
	private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---------";
	private static final String TOTAL_RATE_MESSAGE = "총 수익률은 %.2f입니다.";
	private static final String SQUARE_BRACKETS_OPEN = "[";
	private static final String SQUARE_BRACKETS_CLOSE = "]";
	private static final String REST_DELIMITER = ", ";
	private static final String WINNING_FORMAT = "%s - %d개";

	public static void outputPhraseLotto(final int phraseLottoCount) {
		System.out.println(String.format(PHRASE_LOTTO_MESSAGE, phraseLottoCount));
	}

	public static void outputPickedLottoNumber(final LottoNumberCollection lottoNumberCollection) {
		StringBuilder lottoNumberStringBuilder = new StringBuilder(SQUARE_BRACKETS_OPEN);
		List<Integer> pickLottoNumbers = new ArrayList<>(lottoNumberCollection.getPickLottoNumbers());
		Collections.sort(pickLottoNumbers);

		String lottoNumberString = pickLottoNumbers.stream()
			.map(number -> Integer.toString(number))
			.collect(Collectors.joining(REST_DELIMITER));

		lottoNumberStringBuilder.append(lottoNumberString);
		lottoNumberStringBuilder.append(SQUARE_BRACKETS_CLOSE);

		System.out.println(lottoNumberStringBuilder);
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
