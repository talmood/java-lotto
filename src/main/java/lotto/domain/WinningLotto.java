package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WinningLotto {

    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private static void validate(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers, bonusNumber);
    }

    private static void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicate(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Set.copyOf(lottoNumbers);
    }
}
