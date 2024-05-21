package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    public static void validate(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        if (lottoNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return List.copyOf(lottoNumbers.getNumbers());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
