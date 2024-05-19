package view;

import model.LottoPrize;
import model.LottoWinningResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrizeFormatter {

    FIRST(LottoPrize.FIRST, "6개 일치"),
    SECOND(LottoPrize.SECOND, "5개 일치, 보너스 볼 일치"),
    THIRD(LottoPrize.THIRD, "5개 일치"),
    FOURTH(LottoPrize.FOURTH, "4개 일치"),
    FIFTH(LottoPrize.FIFTH, "3개 일치");

    private final LottoPrize prize;
    private final String prefix;

    LottoPrizeFormatter(LottoPrize prize, String prefix) {
        this.prize = prize;
        this.prefix = prefix;
    }

    public static String format(LottoWinningResult winningResult) {
        final List<LottoPrizeFormatter> sortedFormatters = Stream.of(LottoPrizeFormatter.values())
                .sorted(Comparator.comparingInt(LottoPrizeFormatter::ordinal).reversed())
                .toList();

        return sortedFormatters.stream()
                .map(formatter -> formatter.format(winningResult.getCountBy(formatter.prize)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String format(long matchCount) {
        return this.prefix + "(%d)원 - %d개".formatted(this.prize.prizeAmount(), matchCount);
    }

}
