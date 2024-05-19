package lotto.domain;

import java.util.List;
import java.util.Set;

public class PurchasedLotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private PurchasedLotto(final Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchasedLotto of(final Set<LottoNumber> lottoNumbers) {
        return new PurchasedLotto(lottoNumbers);
    }

    private static void validate(final Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
    }

    private static void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Set.copyOf(lottoNumbers);
    }
}
