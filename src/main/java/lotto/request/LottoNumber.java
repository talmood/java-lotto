package lotto.request;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        return new LottoNumber(number);
    }

    private static void validate(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
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
