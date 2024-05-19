package lotto.domain;

import java.util.Objects;

import static lotto.constrant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constrant.LottoConstant.MIN_LOTTO_NUMBER;

public class LottoNumber {

    private final int number;

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        return new LottoNumber(number);
    }

    private static void validate(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
