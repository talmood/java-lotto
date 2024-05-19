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
}
