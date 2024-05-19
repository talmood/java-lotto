package model;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoWinningResult {

    private final Map<LottoPrize, Long> countByLottoPrize;

    private LottoWinningResult(Map<LottoPrize, Long> countByLottoPrize) {
        this.countByLottoPrize = countByLottoPrize;
    }

    public static LottoWinningResult of(LottoWinningNumbers winningNumbers, LottoTicket lottoTicket) {
        final Map<LottoPrize, Long> countByLottoPrize = lottoTicket.games()
                .stream()
                .map(game -> computeLottoPrize(winningNumbers, game))
                .flatMap(Optional::stream) // empty Optional 제거
                .collect(groupingBy(Function.identity(), counting()));

        return new LottoWinningResult(countByLottoPrize);
    }

    private static Optional<LottoPrize> computeLottoPrize(LottoWinningNumbers winningNumbers, LottoGame game) {
        return LottoPrize.computePrize(
                new WinningNumberMatchCount(game.countMatchedNumber(winningNumbers.fetchWiningGame())),
                new BonusNumberMatched(game.containsNumber(winningNumbers.fetchBonusNumber()))
        );
    }

    public LottoProfit confirmProfit(LottoPurchaseAmount purchaseAmount) {
        return LottoProfit.of(purchaseAmount, calculatePrizeAmount());
    }

    private long calculatePrizeAmount() {
        return this.countByLottoPrize.keySet().stream()
                .mapToLong(prize -> prize.prizeAmount() * countByLottoPrize.get(prize))
                .sum();
    }

    public Map<LottoPrize, Long> countByLottoPrize() {
        return Map.copyOf(this.countByLottoPrize);
    }

    public long getCountBy(LottoPrize prize) {
        return this.countByLottoPrize.getOrDefault(prize, 0L);
    }

}
