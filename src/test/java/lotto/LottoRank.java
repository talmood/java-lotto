package lotto;

import java.util.Arrays;

public enum LottoRank {

	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(5, 50000),
	FOURTH(4, 5000),
	FIFTH(3, 0),
	UNRANKED(0, 0)
	;

	private final int hitCount;
	private final long reward;

	LottoRank(final int hitCount, final long reward) {
		this.hitCount = hitCount;
		this.reward = reward;
	}

	public static LottoRank of(final int hitCount, final boolean hasBonusNumber) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.isSameHitCount(hitCount))
			.filter(lottoRank -> !lottoRank.equals(SECOND) || hasBonusNumber)
			.findFirst()
			.orElse(UNRANKED);
	}

	private boolean isSameHitCount(final int hitCount) {
		return this.hitCount == hitCount;
	}

	public long reward() {
		return this.reward;
	}
}

