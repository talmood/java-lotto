package lotto;

import java.util.Objects;

public class LottoNumber {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final int value;

	private LottoNumber(final int value) {
		this.value = value;
	}

	public static LottoNumber from(final int value) {
		validateNumberRange(value);
		return new LottoNumber(value);
	}

	private static void validateNumberRange(final int value) {
		if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
		}
	}

	public int value() {
		return this.value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final LottoNumber that = (LottoNumber) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
