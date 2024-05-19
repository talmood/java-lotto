package lotto;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.Map;

public class LottoResult {

	private final Map<LottoRank, Integer> rankResults;

	private LottoResult(final Map<LottoRank, Integer> rankResults) {
		this.rankResults = rankResults;
	}

	public static LottoResult of(final Lottos lottos, final WinningLotto winningLotto) {
		final Map<LottoRank, Integer> rankResults = lottos.lottos().stream()
			.collect(groupingBy(winningLotto::calculateRank, summingInt(value -> 1)));
		return new LottoResult(rankResults);
	}

	public int CountBy(final LottoRank lottoRank) {
		return this.rankResults.getOrDefault(lottoRank, 0);
	}

	public double calculateProfitRate() {
		final long totalReward = calculateTotalReward();
		final int purchaseAmount = calculatePurchaseAmount();

		return totalReward / (double) purchaseAmount;
	}

	private long calculateTotalReward() {
		return this.rankResults.entrySet().stream()
			.map(rankResult -> rankResult.getKey().reward() * rankResult.getValue())
			.reduce(0L, Long::sum);
	}

	private int calculatePurchaseAmount() {
		final int numberOfPurchases = this.rankResults.values().stream()
			.mapToInt(i -> i)
			.sum();
		return numberOfPurchases * LottoVendor.LOTTO_PRICE;
	}
}
