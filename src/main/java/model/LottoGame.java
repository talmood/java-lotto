package model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    private LottoGame(List<LottoNumber> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException("로또 숫자는 null일 수 없습니다.");
        }
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 게임의 로또 숫자는 6개여야 합니다.");
        }

        this.numbers = numbers;
    }

    public static LottoGame publish(LottoNumberGenerator numberGenerator) {
        return new LottoGame(numberGenerator.generate());
    }

    public List<LottoNumber> numbers() {
        return List.copyOf(this.numbers);
    }

}
