package model;

import model.lottonumber.LottoNumber;
import model.lottonumber.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public record LottoGame(
        List<LottoNumber> numbers
) {

    public static final int LOTTO_NUMBER_SIZE = 6;

    public LottoGame(List<LottoNumber> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException("로또 숫자는 null일 수 없습니다.");
        }
        validateNumberSize(numbers);

        final List<LottoNumber> sortedAsc = new ArrayList<>(numbers);
        sortedAsc.sort(Comparator.comparingInt(LottoNumber::getNumber));

        this.numbers = List.copyOf(sortedAsc);
    }

    private void validateNumberSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 게임 숫자는 서로 다른 6개로 이루어져야합니다.");
        }

        long distinguishedNumberCount = numbers.stream().map(LottoNumber::getNumber).distinct().count();
        if (distinguishedNumberCount != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 게임 숫자는 서로 다른 6개로 이루어져야합니다.");
        }
    }

    public static LottoGame publish(LottoNumberGenerator numberGenerator) {
        return new LottoGame(numberGenerator.generate());
    }

    public boolean containsNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public long countMatchedNumber(LottoGame other) {
        return this.numbers.stream()
                .filter(other::containsNumber)
                .count();
    }

}
