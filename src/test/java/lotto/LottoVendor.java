package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoVendor {

	public static final int LOTTO_PRICE = 1_000;

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

	public Lottos purchaseAutoLottos() {
		final int purchasableCount = money.calculatePurchasableCount(LOTTO_PRICE);
		final List<Lotto> purchasedAutoLottos = IntStream.rangeClosed(1, purchasableCount)
			.mapToObj(i -> Lotto.from(new LottoNumberAutoGenerator().generate()))
			.collect(Collectors.toList());

		return new Lottos(purchasedAutoLottos);
	}
}
