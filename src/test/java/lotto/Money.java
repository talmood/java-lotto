package lotto;

public class Money {

	private final int money;

	private Money(final int money) {
		this.money = money;
	}

	public static Money from(final int money) {
		MoneyValidator.validate(money);
		return new Money(money);
	}

	public boolean hasEnoughMoneyFor(final int price) {
		return this.money >= price;
	}

	public int calculatePurchasableCount(final int price) {
		return this.money / price;
	}

	public Money minus(final int price) {
		if (!hasEnoughMoneyFor(price)) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
		return Money.from(this.money - price);
	}
}
