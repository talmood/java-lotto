package lotto.request;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLotto;
import lotto.utils.CommaNumberSplitter;
import lotto.utils.PatternUtil;

import java.util.List;
import java.util.Objects;

public class LastWeekWinningLottoRequest {

    private static final String INPUT_PATTERN = "^\\d+(\\s*,\\s*\\d+)*$";
    private static final String ERROR_LOTTO_INPUT_PATTERN = "[ERROR] 로또 번호는 ,로 구분된 숫자여야 합니다.";

    private static final String BONUS_INPUT_PATTERN = "^\\d+$";
    private static final String ERROR_BONUS_INPUT_PATTERN = "[ERROR] 보너스 볼은 숫자로 입력해야 합니다.";

    private final List<Integer> lottoNumbers;
    private final int bonusNumber;

    private LastWeekWinningLottoRequest(final List<Integer> lottoNumbers, final int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LastWeekWinningLottoRequest from(final String lastWeekWinningNumbers, final String bonusNumber) {
        validateInputPattern(lastWeekWinningNumbers);
        validateBonusInputPattern(bonusNumber);
        return new LastWeekWinningLottoRequest(parseLottoNumbers(lastWeekWinningNumbers), Integer.parseInt(bonusNumber));
    }

    private static void validateInputPattern(final String lastWeekWinningNumbers) {
        if (!PatternUtil.isMatched(lastWeekWinningNumbers, INPUT_PATTERN)) {
            throw new IllegalArgumentException(ERROR_LOTTO_INPUT_PATTERN);
        }
    }

    private static void validateBonusInputPattern(final String bonusNumber) {
        if (Objects.isNull(bonusNumber) || !bonusNumber.matches(BONUS_INPUT_PATTERN)) {
            throw new IllegalArgumentException(ERROR_BONUS_INPUT_PATTERN);
        }
    }

    private static List<Integer> parseLottoNumbers(final String lastWeekWinningNumbers) {
        return CommaNumberSplitter.split(lastWeekWinningNumbers);
    }


    public WinningLotto generateWinningLotto() {
        final LottoNumbers generatedLottoNumbers = LottoNumbers.from(this.lottoNumbers.stream()
                .map(LottoNumber::from)
                .toList());

        final LottoNumber generatedBonusNumber = LottoNumber.from(this.bonusNumber);

        return WinningLotto.of(generatedLottoNumbers, generatedBonusNumber);
    }
}
