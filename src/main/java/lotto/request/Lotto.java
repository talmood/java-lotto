package lotto.request;

import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    private Lotto(final List<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto of(final List<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        return new Lotto(lottoNumbers, bonusNumber);
    }

    private static void validate(final List<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers, bonusNumber);
    }

    private static void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicate(final List<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        if (lottoNumbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }
}
