package lotto.domain;

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

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
