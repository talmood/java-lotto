package lotto.request;

import lotto.utils.CommaNumberSplitter;
import lotto.utils.PatternUtil;

import java.util.List;

public class LastWeekWinningLottoRequest {

    private static final String INPUT_PATTERN = "^\\d+(,\\d+)$";
    private static final String ERROR_LOTTO_INPUT_PATTERN = "[ERROR] 로또 번호는 ,로 구분된 숫자여야 합니다.";

    private final List<Integer> lottoNumbers;

    private LastWeekWinningLottoRequest(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LastWeekWinningLottoRequest from(final String lastWeekWinningNumbers) {
        validateInputPattern(lastWeekWinningNumbers);
        return new LastWeekWinningLottoRequest(parseLottoNumbers(lastWeekWinningNumbers));
    }

    private static void validateInputPattern(final String lastWeekWinningNumbers) {
        if (!PatternUtil.isMatched(lastWeekWinningNumbers, INPUT_PATTERN)) {
            throw new IllegalArgumentException(ERROR_LOTTO_INPUT_PATTERN);
        }
    }

    private static List<Integer> parseLottoNumbers(final String lastWeekWinningNumbers) {
        return CommaNumberSplitter.split(lastWeekWinningNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }
}
