package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	public static void printExceptionMessage(final Exception e) {
		System.out.println(e.getMessage());
	}

	public static void printLottoPurchaseResult(final Lottos manualLottos, final Lottos autoLottos) {
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.countPurchasedLottos(), autoLottos.countPurchasedLottos());
		manualLottos.lottos().forEach(OutputView::printLottos);
		autoLottos.lottos().forEach(OutputView::printLottos);
	}

	private static void printLottos(final Lotto lotto) {
		final String lottoNumbers = lotto.lottoNumbers().stream()
			.map(LottoNumber::value)
			.map(String::valueOf)
			.collect(Collectors.joining(", "));
		System.out.printf("[%s]\n", lottoNumbers);
	}

	public static void printLottoResult(final LottoResult lottoResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		getLottoRanks().stream()
			.filter(LottoRank::hasReward)
			.forEach(lottoRank -> printRankResult(lottoRank, lottoResult.CountBy(lottoRank)));
		System.out.printf("총 수익률은 %.2f입니다.\n", lottoResult.calculateProfitRate());
	}

	private static List<LottoRank> getLottoRanks() {
		final List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
		Collections.reverse(lottoRanks);
		return lottoRanks;
	}

	private static void printRankResult(final LottoRank lottoRank, final int rankCount) {
		if (lottoRank == LottoRank.SECOND) {
			System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", lottoRank.hitCount(), lottoRank.reward(), rankCount);
			return;
		}
		System.out.printf("%d개 일치 (%d원) - %d개\n", lottoRank.hitCount(), lottoRank.reward(), rankCount);
	}
}
