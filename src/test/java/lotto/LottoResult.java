package lotto;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

	private final Map<LottoRank, Integer> rankResults;

	private LottoResult(final Map<LottoRank, Integer> rankResults) {
		this.rankResults = rankResults;
	}

	public static LottoResult of(final Lottos manualLottos, final Lottos autoLottos, final WinningLotto winningLotto) {
		final Map<LottoRank, Integer> manualLottoResults = groupBy(manualLottos, winningLotto);
		final Map<LottoRank, Integer> autoLottoResults = groupBy(autoLottos, winningLotto);
		final Map<LottoRank, Integer> results = mergeResults(manualLottoResults, autoLottoResults);

		return new LottoResult(results);
	}

	private static Map<LottoRank, Integer> groupBy(final Lottos autoLottos, final WinningLotto winningLotto) {
		return autoLottos.lottos().stream()
			.collect(groupingBy(winningLotto::calculateRank, summingInt(value -> 1)));
	}

	private static Map<LottoRank, Integer> mergeResults(Map<LottoRank, Integer> manualResults, Map<LottoRank, Integer> autoResults) {
		Map<LottoRank, Integer> combinedResults = new EnumMap<>(LottoRank.class);

		for (LottoRank rank : LottoRank.values()) {
			combinedResults.put(rank, manualResults.getOrDefault(rank, 0) + autoResults.getOrDefault(rank, 0));
		}

		return combinedResults;
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
