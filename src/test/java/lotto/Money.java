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
}
