package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(final List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> lottoNumberSet = Set.copyOf(lottoNumbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }
}
