package lotto.view.printer;

public class DefaultPrizePrinter implements PrizePrinter {

    private static final String WINNING_STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개";

    @Override
    public void print(final int matchCount, final int money, final int count) {
        System.out.println(String.format(WINNING_STATISTICS_FORMAT, matchCount, money, count));
    }
}