package model.lottonumber;

import java.util.List;

public class FakeLottoNumberGenerator implements LottoNumberGenerator {

    private final List<LottoNumber> numbers;

    public FakeLottoNumberGenerator(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumberGenerator fromNumbers(List<Integer> numbers) {
        return new FakeLottoNumberGenerator(numbers.stream().map(LottoNumber::new).toList());
    }

    @Override
    public List<LottoNumber> generate() {
        return this.numbers;
    }

}
