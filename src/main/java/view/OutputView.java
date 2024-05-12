package view;

import vo.LottoNumberCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String PHRASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";
	private static final String SQUARE_BRACKETS_OPEN = "[";
	private static final String SQUARE_BRACKETS_CLOSE = "]";
	private static final String REST_DELIMITER = ", ";

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

}
