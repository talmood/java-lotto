package lotto.domain;

import java.util.List;
import java.util.Set;

import static lotto.constrant.LottoConstant.LOTTO_NUMBER_SIZE;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    private LottoNumbers(final List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers from(final List<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
    }

    private void validateSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> numbers) {
        final Set<LottoNumber> lottoNumberSet = Set.copyOf(numbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return List.copyOf(numbers);
    }

    public int calculateMatchCounts(final List<LottoNumber> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containsBonusNumber(final LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
