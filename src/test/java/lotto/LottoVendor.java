package lotto;

public class LottoVendor {

	private static final int LOTTO_PRICE = 1_000;

	private final Money money;

	private LottoVendor(final Money money) {
		this.money = money;
	}

	public static LottoVendor from(final Money money) {
		validateMinimumAmount(money);
		return new LottoVendor(money);
	}

	private static void validateMinimumAmount(final Money money) {
		if (!money.hasEnoughMoneyFor(LOTTO_PRICE)) {
			throw new IllegalArgumentException("로또 한 장 가격은 1,000원입니다. 로또를 구매하시려면 1,000원 이상 입력해 주세요.");
		}
	}
}
