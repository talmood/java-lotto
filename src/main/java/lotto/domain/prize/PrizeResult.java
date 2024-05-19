package lotto.domain.prize;

import lotto.constrant.LottoConstant;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> prizeCounts;

    private PrizeResult() {
        prizeCounts = new EnumMap<>(Prize.class);
        initializeCounts();
    }

    private void initializeCounts() {
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeCounts.put(prize, 0));
    }

    public static PrizeResult from(final List<PurchasedLotto> purchasedLottos, final WinningLotto winningLotto) {
        final PrizeResult prizeResult = new PrizeResult();
        purchasedLottos.forEach(purchasedLotto -> prizeResult.calculateAndRecordPrize(purchasedLotto.getLottoNumbers(), winningLotto));
        return prizeResult;
    }

    private void calculateAndRecordPrize(final LottoNumbers lottoNumbers, final WinningLotto winningLotto) {
        final int matchCount = lottoNumbers.calculateMatchCounts(winningLotto.getLottoNumbers());
        final boolean isContainBonusNumber = lottoNumbers.containsBonusNumber(winningLotto.getBonusNumber());

        final Prize prize = Prize.of(matchCount, isContainBonusNumber);
        prizeCounts.put(prize, prizeCounts.get(prize) + 1);
    }

    public Map<Prize, Integer> getPrizeCounts() {
        return prizeCounts;
    }

    public double calculateEarningRate() {
        final long totalPrize = calculateTotalPrize();
        final long totalPurchaseAmount = calculateTotalPurchaseAmount();
        final double earningRate = (double) totalPrize / totalPurchaseAmount;
        return Math.floor(earningRate * 100) / 100.0;
    }


    private long calculateTotalPrize() {
        return prizeCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    private long calculateTotalPurchaseAmount() {
        final long totalPurchaseCount = prizeCounts.values().stream()
                .mapToLong(Integer::longValue)
                .sum();

        return totalPurchaseCount * LottoConstant.LOTTO_PRICE;
    }
}
