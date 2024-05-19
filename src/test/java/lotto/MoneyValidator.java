package lotto;

class MoneyValidator {

	static void validate(final int money) {
		validateNegative(money);
		validateZero(money);
	}

	private static void validateNegative(final int money) {
		if (money < 0) {
			throw new IllegalArgumentException("돈은 음수가 될 수 없습니다.");
		}
	}

	private static void validateZero(final int money) {
		if (money == 0) {
			throw new IllegalArgumentException("최소 1원 이상이어야 합니다.");
		}
	}
}