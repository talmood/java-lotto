package model.lottonumber;

import java.util.Objects;

public final class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    LottoNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하여야합니다.");
        }
        this.number = number;
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
