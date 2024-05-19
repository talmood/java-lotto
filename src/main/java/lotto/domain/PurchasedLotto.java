package lotto.domain;

import java.util.List;
import java.util.Objects;

public class PurchasedLotto {

    private final LottoNumbers lottoNumbers;

    private PurchasedLotto(final LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchasedLotto from(final LottoNumbers lottoNumbers) {
        return new PurchasedLotto(lottoNumbers);
    }

    private static void validate(final LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("lotto numbers must not be null");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return List.copyOf(lottoNumbers.getNumbers());
    }

    public int calculateMatchCounts(final WinningLotto winningLotto) {
        return lottoNumbers.calculateMatchCounts(winningLotto.getLottoNumbers());
    }

    public boolean containsBonusNumber(final WinningLotto winningLotto) {
        return lottoNumbers.containsBonusNumber(winningLotto.getBonusNumber());
    }
}
