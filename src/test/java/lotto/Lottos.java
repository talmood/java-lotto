package lotto;

import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public int countPurchasedLottos() {
		return this.lottos.size();
	}

	public List<Lotto> lottos() {
		return List.copyOf(this.lottos);
	}
}
